package com.rloayza.classroom.restapi.framework;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * All the specifications must extend this class.
 *
 */
public class AbstractSpecification<T> implements Specification<T> {

    private SearchCriteria criteria;

    public void setCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    /**
     *
     * @param root
     * @param criteriaQuery
     * @param builder
     * @return Predicate for search operations
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {

        if (root.get(criteria.getKey()).getJavaType() == String.class) {
            return builder.like(
                    root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
    }
}
