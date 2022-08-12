package com.miw.gildedrose.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.miw.gildedrose.Exception.UserDefinedSystemException;
import com.miw.gildedrose.domain.BuyItemDetails;
import com.miw.gildedrose.domain.Item;
import com.miw.gildedrose.domain.messaging.BuyGildedRoseInvenotryRequest;
import com.miw.gildedrose.persistence.BuyGlidedRoseRepository;
import com.miw.gildedrose.persistence.GildedRoseRepository;
import com.miw.gildedrose.util.SurgePriceUtil;

import io.swagger.v3.oas.annotations.media.Schema;

@Service
public class GildedRoseService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(GildedRoseService.class);

	/** The trading list trades dao */
	@Autowired
	private GildedRoseRepository gildedRoseRepository;

	/** The trading list trades dao */
	@Autowired
	private BuyGlidedRoseRepository buyGlidedRoseRepository;

	@Autowired
	private SurgePriceUtil surgePriceUtil;

	public List<Item> getAllGlideRoseInventories() {
		logger.info("Entering GildedRoseService for getAllGlideRoseInventories()");
		List<Item> items = gildedRoseRepository.findAll();
		logger.info("items : " + items);
		return items;
	}

	public Item getGlideRoseInventory(String name) {
		logger.info("Entering GildedRoseService for getGlideRoseInventory()");
		Item item = gildedRoseRepository.findByName(name);
		if (Objects.nonNull(item)) {
			try {
				adjustSurgePrice(item);
			} catch (Exception ex) {
				logger.error("Execption in adjustSurgePrice : ", ex);
				throw new UserDefinedSystemException("Execption in AdjustSurgePrice utility");
			}
		}
		logger.info("item : " + item);
		return item;
	}

	public Item saveGlideRoseInventory(Item item) {
		return gildedRoseRepository.save(item);
	}

	public BuyItemDetails buyGlideRoseInventory(BuyGildedRoseInvenotryRequest request) throws Exception {
		logger.info("Entering GildedRoseService for buyGlideRoseInventory()");
		BuyItemDetails buyItemDetails = request.getBuyItems();

		List<Item> requestedItemEntities = request.getBuyItems().getItemEntities();
		List<Item> allItemEntities = getAllGlideRoseInventories();
		boolean isSubset = false;
		if (CollectionUtils.isNotEmpty(allItemEntities))
			isSubset = allItemEntities.containsAll(requestedItemEntities);
		if (!isSubset) {
			throw new UserDefinedSystemException(
					"One of the item is not present. Please review your order before buying");
		}

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		buyItemDetails.setUserInfo(username);
		buyItemDetails.setBuyTime(LocalDateTime.now());
		logger.info("buyItemDetails : " + buyItemDetails);

		BuyItemDetails buyItemDetailsResponse = buyGlidedRoseRepository.save(buyItemDetails);
		return buyItemDetailsResponse;
	}

	public void adjustSurgePrice(Item item) {
		logger.info("Entering adjustSurgePrice function: ");
		double currentPrice = surgePriceUtil.calculateSurgeAction(item);
		if (item.price != currentPrice) {
			item.setPrice(currentPrice);
			gildedRoseRepository.save(item);
		}
	}

}
