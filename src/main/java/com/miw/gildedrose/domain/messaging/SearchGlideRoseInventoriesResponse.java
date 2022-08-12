package com.miw.gildedrose.domain.messaging;

import java.util.List;

import com.miw.gildedrose.domain.Item;

public class SearchGlideRoseInventoriesResponse //extends BaseSearchApiResponse<Item>
{

	 /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5351965562088914623L;

    /**
     * Constructor Search GlideRoseInventories Response.
     * 
     * @param records all records
     * @param recordsAsked No of records asked
     */
    public SearchGlideRoseInventoriesResponse(List<Item> records, int recordsAsked) {
//        super(records, recordsAsked);
    }

    /**
     * Constructor Search GlideRose Inventories Response.
     */
    public SearchGlideRoseInventoriesResponse() {
        super();
    }
}
