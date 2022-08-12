package com.miw.gildedrose.domain.messaging;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.miw.gildedrose.domain.SearchEntity;

@JsonPropertyOrder({"searchTimestamp", "recordCount", "totalRecordCount", "moreExist", "records"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseSearchApiResponse<T extends SearchEntity> extends BaseApiResponse  {

	private static final long serialVersionUID = -853717424828470124L;

   
    private Integer totalRecordCount;

   
    private String searchTimestamp;

   
    private boolean moreExist;

 
    private List<T> records = new ArrayList<T>();



    /**
     * Gets Record Count.
     * 
     * @return record count.
     */
    @JsonProperty
    public Integer getRecordCount() {
        return CollectionUtils.isEmpty(getRecords()) ? null : getRecords().size();
    }

    @JsonIgnore
    private void setRecordCount(int recordCount) {}


    public BaseSearchApiResponse() {
        super();
    }

    public BaseSearchApiResponse(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * This class represents Constructor to initialize BaseSearch Response.
     * 
     * @param records records returned form search data.
     * @param recordsAsked recordsAsked is number of records expected in response.
     */
    public BaseSearchApiResponse(List<T> records, int recordsAsked) {
        setMoreExist(false);
        if (recordsAsked != 0 && records != null && records.size() == recordsAsked + 1) {
            setMoreExist(true);
            records.remove(records.size() - 1);
        }
        setRecords(records);

        this.totalRecordCount = CollectionUtils.isNotEmpty(records) ? records.get(0).getTotalRecordsCount() : 0;
        this.searchTimestamp = CollectionUtils.isNotEmpty(records) ? records.get(0).getSearchTimestamp() : null;


    }

    /**
     * Retrieves total record count.
     * 
     * @return totalRecordCount.
     */
    public Integer getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Returns time stamp.
     * 
     * @return searchTimestamp.
     */
    public String getSearchTimestamp() {
        return searchTimestamp;
    }

    /**
     * Gets the records.
     * 
     * @return records.
     */
    @JsonProperty
    public List<T> getRecords() {
        return records;
    }

    /**
     * Sets the records.
     * 
     * @param records new records.
     */
    private void setRecords(List<T> records) {
        this.records = records;
    }

    /**
     * Checks for records if more exist or not.
     * 
     * @return boolean moreExist.
     */
    @JsonProperty
    public boolean isMoreExist() {
        return moreExist;
    }

    /**
     * Sets the boolean according to records if exist or not.
     * 
     * @param moreExist boolean moreExist.
     */
    public void setMoreExist(boolean moreExist) {
        this.moreExist = moreExist;

    }
}
