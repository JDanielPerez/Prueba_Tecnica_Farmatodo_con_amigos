package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.dtos.ProductDTO;
import com.farmatodo.farmatodo.models.entities.Product;
import com.farmatodo.farmatodo.repositories.ProductRepository;
import com.farmatodo.farmatodo.repositories.ProductSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(ProductDTO productDTO){
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .reference(productDTO.getReference())
                .quantity(productDTO.getQuantity())
                .price(productDTO.getPrice())
                .active(productDTO.isActive())
                .build();

        validateProduct(product);
        productRepository.save(product);
    }

    //que pasa si en lugar de un insertar es un actualizar
    private void validateProduct(Product product) {
        if(productRepository.existsByReference(product.getReference()) && product.getId() == null){
            throw new IllegalArgumentException("Ya existe un producto con la referencia: "+ product.getReference());
        }
    }

    public List<Product> search(String name, String reference) {
        return productRepository.findAll(ProductSpecifications.hasFilters(name, reference));
    }

    public void updateQuantity(Product product, BigDecimal quantity){

        product.setQuantity(product.getQuantity().subtract(quantity));
        productRepository.save(product);
    }
}
