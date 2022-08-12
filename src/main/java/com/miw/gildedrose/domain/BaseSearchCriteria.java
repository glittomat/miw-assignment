package com.miw.gildedrose.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseSearchCriteria<T extends Enum<?>> {
	


    /** The sort by. */
    
    private T sortBy;

    /** The sort direction. */    
    private SortDirection sortDirection;

    /**
     * Gets the sort by.
     *
     * @return the sort by
     */
    public T getSortBy() {
        return sortBy;
    }

    /**
     * Sets the sort by.
     *
     * @param sortBy the new sort by
     */
    public void setSortBy(T sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * Gets the sort direction.
     *
     * @return the sort direction
     */
    public SortDirection getSortDirection() {
        return sortDirection;
    }

    /**
     * Sets the sort direction.
     *
     * @param sortDirection the new sort direction
     */
    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }



}
