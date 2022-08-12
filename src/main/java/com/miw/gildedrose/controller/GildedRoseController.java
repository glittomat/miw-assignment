package com.miw.gildedrose.controller;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miw.gildedrose.domain.BuyItemDetails;
import com.miw.gildedrose.domain.Item;
import com.miw.gildedrose.domain.messaging.BuyGildedRoseInvenotryRequest;
import com.miw.gildedrose.domain.messaging.GetGildedRoseInvenotriesResponse;
import com.miw.gildedrose.domain.messaging.GetGildedRoseInvenotryResponse;
import com.miw.gildedrose.service.GildedRoseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class GildedRoseController {
	
	/**
     * The Constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(GildedRoseController.class);

    /**
     * The constant USERNAME.
     */
    private static final String USERNAME = "userName";

    /** ObjectMapper for json conversions. */
    private static ObjectMapper mapper = new ObjectMapper();

    /** The trading list service. */
    @Autowired
    private GildedRoseService gildedRoseService;
        
    @GetMapping(value = {"/getAllInventories"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Get TradingLists profile data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = GetGildedRoseInvenotriesResponse.class))),
            @ApiResponse(responseCode = "500",
                description = "REST_ERR_ALL_MESSAGE: System error, unable to perform operation. Please contact MIW.', <br />",
                content = @Content(schema = @Schema(implementation = Item.class))),          
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST: 'Bad Request', <br />",
                content = @Content(schema = @Schema(implementation = Item.class)))})   
    public ResponseEntity<GetGildedRoseInvenotriesResponse> getAll(@RequestHeader(name = "Generic Headers", required = false) Map<String, String> headers,
        @RequestParam(defaultValue = "false", required = false) Map<String, String> queryParams) throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();
        try {
            logger.info("Entering GildedRoseController for retrieving all the inventories");     
            List<Item> itemEntities = gildedRoseService.getAllGlideRoseInventories();
            GetGildedRoseInvenotriesResponse getItemEntities = new GetGildedRoseInvenotriesResponse(itemEntities);
            System.out.println("getItemEntities : ");
            return new ResponseEntity<GetGildedRoseInvenotriesResponse>(getItemEntities, HttpStatus.OK);
//            return itemEntities;
        } finally {
            watch.stop();
            logger.info("Time taken to GetTradingListsProfileData request :{} ms ", watch.getTotalTimeMillis());
        }
    }
	
    @GetMapping(value = {"/getInventory/{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Get TradingLists profile data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = GetGildedRoseInvenotriesResponse.class))),
            @ApiResponse(responseCode = "500",
                description = "REST_ERR_ALL_MESSAGE: System error, unable to perform operation. Please contact MIW.', <br />",
                content = @Content(schema = @Schema(implementation = Item.class))),          
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST: 'Bad Request', <br />",
                content = @Content(schema = @Schema(implementation = Item.class)))})   
    public ResponseEntity<GetGildedRoseInvenotryResponse> get(@PathVariable(name = "id", required = true) String name,
        @RequestHeader(name = "Generic Headers", required = false) Map<String, String> headers,
        @RequestParam(defaultValue = "false", required = false) Map<String, String> queryParams) throws Exception {

        StopWatch watch = new StopWatch();
        watch.start();
        try {        	    	
            logger.info("Entering GildedRoseController for getting the details of a single inventory");     
            Item item = gildedRoseService.getGlideRoseInventory(name);
            GetGildedRoseInvenotryResponse getItemEntity = new GetGildedRoseInvenotryResponse(item);
            return new ResponseEntity<GetGildedRoseInvenotryResponse>(getItemEntity, HttpStatus.OK);
        } finally {
            watch.stop();
            logger.info("Time taken to GetTradingListsProfileData request :{} ms ", watch.getTotalTimeMillis());
        }
    }
    
    
    @PostMapping(value = {"/buyInventory"}, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Get TradingLists profile data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = GetGildedRoseInvenotriesResponse.class))),
            @ApiResponse(responseCode = "500",
                description = "REST_ERR_ALL_MESSAGE: System error, unable to perform operation. Please contact MIW.', <br />",
                content = @Content(schema = @Schema(implementation = Item.class))),          
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST: 'Bad Request', <br />",
                content = @Content(schema = @Schema(implementation = Item.class)))})   
    public ResponseEntity<BuyItemDetails> buyInventory(@RequestBody BuyGildedRoseInvenotryRequest request, 
    		@RequestHeader(name = "Generic Headers", required = false) Map<String, String> headers,
        @RequestParam(defaultValue = "false", required = false) Map<String, String> queryParams) throws Exception {

        StopWatch watch = new StopWatch();
        watch.start();
        try {
            logger.info("Entering GildedRoseController for buying all the requested inventories");     
            BuyItemDetails buyItemDetails =   gildedRoseService.buyGlideRoseInventory(request);
            return new ResponseEntity<BuyItemDetails>(buyItemDetails, HttpStatus.OK);

        } finally {
            watch.stop();
            logger.info("Time taken to GetTradingListsProfileData request :{} ms ", watch.getTotalTimeMillis());
        }
    }
    
    
    @PostMapping(value = {"/saveInvetory"},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Item saveInventories(@RequestBody Item item) {
    	return gildedRoseService.saveGlideRoseInventory(item);
    }
}
