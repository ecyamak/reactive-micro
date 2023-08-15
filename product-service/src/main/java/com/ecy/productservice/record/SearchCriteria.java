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
        Filter _filter = null;
        if (filter.isPresent())
            _filter = new Filter(filter.get(), value.orElseThrow(RequestParamMismatch::new), operator.orElse("is"));

        Sort _sort = null;
        if (sort.isPresent())
            _sort = Sort.by(Sort.Direction.fromString(order.orElse("asc")), sort.get());

        Pageable _pageable = null;
        if (page.isPresent()) {
            if (sort.isPresent())
                _pageable = PageRequest.of(page.get(), size.orElse(2), _sort);
            else
                _pageable = PageRequest.of(page.get(), size.orElse(2));
        }

        return new SearchCriteria(_filter, _pageable, _sort);
    }

    public record Filter(String key, String value, String operator) {

    }

}