package com.miw.gildedrose.Exception;

public class UserDefinedSystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7240258446277130285L;
	
	public UserDefinedSystemException(String str)  
    {  
        // Calling constructor of parent Exception  
        super(str);  
    } 
}
