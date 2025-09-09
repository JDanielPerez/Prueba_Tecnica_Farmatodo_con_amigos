package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.dtos.OrderDetailDTO;
import com.farmatodo.farmatodo.models.dtos.PaymentMethodDto;
import com.farmatodo.farmatodo.models.entities.*;
import com.farmatodo.farmatodo.models.enums.OrderStatus;
import com.farmatodo.farmatodo.models.enums.PaymentStatus;
import com.farmatodo.farmatodo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CustomerPaymentMethodRepository customerPaymentMethodRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SendMailService sendMailService;

    @Value("${spring.variables.failProbabilityConfiguration}")
    private int failProbabilityConfiguration;
    @Value("${spring.variables.paymentAttemptsConfiguration}")
    private int PaymentAttemptsConfiguration;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order payOrder(Long paymentMethodId, Long orderId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerService.findByUserUsername(authentication.getName());

        Order order = orderRepository.findById(orderId).get();
        CustomerPaymentMethod customerPaymentMethod = customerPaymentMethodRepository.findByCustomerAndId(customer, paymentMethodId).get();

        if(order.getPaymentAttempts() > PaymentAttemptsConfiguration){
            order.setOrderStatus(OrderStatus.CANCELLED);
            order.setPaymentStatus(PaymentStatus.REFUNED);
            orderRepository.save(order);
            sendMailService.sendEmail(customer.getEmail(),"Rechazo en el pago","El numero de intentos para pagar ha sido superado");
            throw new IllegalArgumentException("Se excedieron el maximo de intentos para pagar");
        }

        if(!order.getOrderStatus().equals(OrderStatus.PENDING) && !order.getOrderStatus().equals(PaymentStatus.PENDING) && !order.getOrderStatus().equals(PaymentStatus.PAID) ){
            throw new IllegalArgumentException("No se puede pagar esta orden porque esta en estado: "+ order.getOrderStatus());
        }

        int failProbability = (int) (Math.random()* 100);
        if(failProbability < failProbabilityConfiguration){
            order.setPaymentStatus(PaymentStatus.FAILED);
            order.setPaymentAttempts(order.getPaymentAttempts()+1);
            orderRepository.save(order);
            throw new IllegalArgumentException("fallo al momento de hacer el pago");
        }

        order.setOrderStatus(OrderStatus.PAID);
        order.setPaymentDate(LocalDateTime.now());
        order.setCustomerPaymentMethodId(customerPaymentMethod);
        order.setPaymentAttempts(order.getPaymentAttempts()+1);
        order.setPaymentStatus(PaymentStatus.PAID);
        orderRepository.save(order);
        sendMailService.sendEmail(customer.getEmail(),"Pago exitoso","Se proceso correctamente el pago");
        return order;
    }

    public void validateOrder(OrderDetailDTO orderDetailDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Customer customer = customerService.findByUserUsername(authentication.getName());
        Order order = new Order();
        Optional<Order> orderOptional = orderRepository.findByCustomerAndOrderStatus(customer, OrderStatus.PENDING);

        if(orderOptional.isPresent()){
            order = orderOptional.get();

        }
        else{
            order = Order.builder()
                    .customer(customer)
                    .orderStatus(OrderStatus.PENDING)
                    .paymentStatus(PaymentStatus.PENDING)
                    .totalValue(BigDecimal.ZERO)
                    .build();

            orderRepository.save(order);
        }
        addItem(order,orderDetailDTO);

        List<OrderDetail> listOrderDetail = orderDetailRepository.findByOrderId(order.getId());

        BigDecimal totalOrder = BigDecimal.ZERO;
        for(OrderDetail orderDetail : listOrderDetail){
            totalOrder = totalOrder.add(orderDetail.getTotal());
        }

        order.setTotalValue(totalOrder);
        orderRepository.save(order);
    }



    public void addItem(Order order,OrderDetailDTO orderDetailDTO){

            Product product = productRepository.findById(orderDetailDTO.getProductId()).get();

            if(product.getQuantity().compareTo(orderDetailDTO.getQuantity()) == -1){
                throw new IllegalArgumentException("La cantidad ingresada supera al stock actual");
            }
            BigDecimal orderDetailTotal = (orderDetailDTO.getQuantity()).multiply(product.getPrice());

            OrderDetail orderDetail = OrderDetail.builder()
                    .order(order)
                    .product(product)
                    .quantity(orderDetailDTO.getQuantity())
                    .total(orderDetailTotal)
                    .build();

            orderDetailRepository.save(orderDetail);
            productService.updateQuantity(product, orderDetailDTO.getQuantity());
    }

}
