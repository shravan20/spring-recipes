package com.example.employee.commons.utils;

import javax.annotation.Nullable;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.function.Predicate;

public interface Specification<T> extends Serializable {

    @Nullable
    Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                          CriteriaBuilder criteriaBuilder);
    
}