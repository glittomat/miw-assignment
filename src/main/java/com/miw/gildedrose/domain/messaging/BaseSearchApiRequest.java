package com.miw.gildedrose.domain.messaging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.miw.gildedrose.domain.BaseSearchCriteria;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;

/**
 * BaseSearchRequest is part of a generic request.
 * 
 * @param <T> BaseSearchCriteria represents generic Search Criteria.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class BaseSearchApiRequest<T extends BaseSearchCriteria<?>> {

    private static final long serialVersionUID = 6962424609464886397L;

    @Valid
//    @IsCriteriaValid    
    private T criteria;


    /**
     * Constructor for BaseSearchRequest.
     * 
     * @param pageNumber represents pageNumber.
     * @param pageSize represents pageSize
     */
    public BaseSearchApiRequest(int pageNumber, int pageSize) {
//        super(pageNumber, pageSize);
    }

    /**
     * Constructor for BaseSearchRequest.
     * 
     * @param pageNumber represents pageNumber.
     */
    public BaseSearchApiRequest(int pageNumber) {
//        super(pageNumber);
    }

    public BaseSearchApiRequest() {
        super();
    }

    public T getCriteria() {
        return criteria;
    }

    public void setCriteria(T criteria) {
        this.criteria = criteria;
    }

}
