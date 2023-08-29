package com.ecy.data.service.mongo;

import com.ecy.data.record.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 22:26
 */

@RequiredArgsConstructor
public class AbstractBaseService {

    protected final ReactiveMongoTemplate mongoTemplate;

    protected  <T, S> Flux<T> search(SearchCriteria searchCriteria, Class<S> sourceType, Class<T> resultType) {
        Criteria criteria = getCriteria(searchCriteria.filter());
        List<AggregationOperation> operations = new ArrayList<>();
        operations.add(Aggregation.match(criteria));
        if (searchCriteria.isPaged()) {
            operations.add(Aggregation.skip(searchCriteria.pageable().getOffset()));
            operations.add(Aggregation.limit(searchCriteria.pageable().getPageSize()));
        }
        if (searchCriteria.isSorted()) {
            operations.add(Aggregation.sort(searchCriteria.sort()));
        }
        operations.add(Aggregation.project(resultType));
        Aggregation aggregation = Aggregation.newAggregation(operations);
        return mongoTemplate.aggregate(aggregation, sourceType, resultType);
    }

    private Criteria getCriteria(SearchCriteria.Filter filter) {
        Criteria criteria = Criteria.where(filter.key());
        return switch (filter.operator()) {
            case "ne" -> criteria.ne(filter.value());
            case "lt" -> criteria.lt(filter.value());
            default -> criteria.is(filter.value());
        };
    }

}