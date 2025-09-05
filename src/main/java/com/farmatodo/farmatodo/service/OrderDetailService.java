package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.OrderDetail;
import com.farmatodo.farmatodo.repository.OrderDetailRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private OrderDetailRepository orderDetailRepository;

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    //VALIDAR QUE NO SE PUEDA ELMINAR UN DETALLE CUANDO EL PEDIDO YA ESTA PAGO
    public void deleteOrderDetail(OrderDetail orderDetail){
        orderDetailRepository.delete(orderDetail);
    }

    public List<OrderDetail> getAllOrderDetail(){
        return orderDetailRepository.findAll();
    }

    /*
     * Obtiene todos los detalles asociados a un pedido por su identificador.
     *
     * @param id Identificador único del pedido (no debe ser null).
     * @return Lista de {@link OrderDetail} vinculados al pedido.
     *         Si no hay coincidencias, retorna una lista vacía.
     * @throws IllegalArgumentException si {@code id} es null.
     */
    public List<OrderDetail> findByOrderId(Long id){
        return orderDetailRepository.findByOrderId(id);
    }
}
