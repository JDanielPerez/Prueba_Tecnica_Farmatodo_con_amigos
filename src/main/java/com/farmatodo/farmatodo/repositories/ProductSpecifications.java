package com.farmatodo.farmatodo.repositories;
import com.farmatodo.farmatodo.models.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecifications {

    public static Specification<Product> hasFilters(BigDecimal minQuantity, String name, String reference) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // condición obligatoria
            predicates.add(cb.greaterThan(root.get("quantity"), minQuantity));

            // opcionales
            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (reference != null && !reference.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("reference")), "%" + reference.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

