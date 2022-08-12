package com.miw.gildedrose.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SearchEntity extends Serializable {

	/** The Constant MIN_DATE. */
    @SuppressWarnings("deprecation")
    public static final Date MIN_DATE = new Date(0, 0, 1);

    /** The Constant MAX_DATE. */
    @SuppressWarnings("deprecation")
    public static final Date MAX_DATE = new Date(9999 - 1900, 11, 31);

    /**
     * UTC Timestamp format - Product Standard.
     *
     */
    public static final String UTC_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH.mm.ss'Z'";
    /**
     * Zone id for UTC.
     */
    public static final String ZONE_UTC = "UTC";

    /**
     * This method is to get Total Records Count.
     *
     * @return totalRecordsCount
     */
    public int getTotalRecordsCount();

    /**
     * 'default' implementation for timestamp that can be removed by overriding.
     * 
     * @return searchTimeStamp
     */
    @JsonIgnore
    public default String getSearchTimestamp() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(UTC_TIMESTAMP_FORMAT);
        return formatter.format(ldt);
    }
}
