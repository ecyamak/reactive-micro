package com.ecy.firstservice.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 9.08.2023
 * Time: 21:37
 */

public class BaseService<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> clazz;

    protected BaseService(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected List<T> search(String filter, String subFilter, String operation, String value, Integer page) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        Path path = subFilter == null ? root.get(filter) : root.get(filter).get(subFilter);

        switch (operation) {
            case "like":
                criteriaQuery.select(root).where(criteriaBuilder.like(path, value));
                break;
            default:
                criteriaQuery.select(root).where(criteriaBuilder.equal(path, value));
        }

        Query query = entityManager.createQuery(criteriaQuery);

        if (page != null) {
            int pageSize = 2;
            query.setFirstResult(Math.multiplyExact(page, pageSize));
            query.setMaxResults(pageSize);
        }

        return query.getResultList();
    }



}