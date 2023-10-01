package com.ecy.productservice.record;

import com.ecy.productservice.exception.RequestParamMismatch;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

/**
 * Author: ecyamak
 * Date: 11.08.2023
 * Time: 14:33
 */

public record SearchCriteria(Filter filter, Pageable pageable, Sort sort) {

    public boolean isFiltered() {
        return filter != null;
    }

    public boolean isPaged() {
        return pageable != null;
    }

    public boolean isSorted() {
        return sort != null;
    }

    public static SearchCriteria of(Optional<String> filter, Optional<String> value, Optional<String> operator,
                                    Optional<Integer> page, Optional<Integer> size,
                                    Optional<String> sort, Optional<String> order) {
        Filter searchFilter = null;
        if (filter.isPresent())
            searchFilter = new Filter(filter.get(), value.orElseThrow(RequestParamMismatch::new), operator.orElse("is"));

        Sort searchSort = null;
        if (sort.isPresent())
            searchSort = Sort.by(Sort.Direction.fromString(order.orElse("asc")), sort.get());

        Pageable searchPageable = null;
        if (page.isPresent()) {
            if (sort.isPresent())
                searchPageable = PageRequest.of(page.get(), size.orElse(2), searchSort);
            else
                searchPageable = PageRequest.of(page.get(), size.orElse(2));
        }

        return new SearchCriteria(searchFilter, searchPageable, searchSort);
    }

    public record Filter(String key, String value, String operator) {

    }

}