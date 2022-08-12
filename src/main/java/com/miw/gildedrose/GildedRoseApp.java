package com.miw.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.context.annotation.Bean;

import com.miw.gildedrose.controller.GildedRoseController;

@SpringBootApplication
//@EnableOAuth2Sso //When Oauth2 sued for authentication @EnableOAuth2Client -> When you want to make API call & you dont want to leverage  OAUTh for Authentication.
public class GildedRoseApp {

	private static final Logger logger = LoggerFactory.getLogger(GildedRoseApp.class);
    
	public static void main(String[] args) {
    	logger.info("***Inside GildedRoseApp");
        SpringApplication.run(GildedRoseApp.class, args);
    }
}
