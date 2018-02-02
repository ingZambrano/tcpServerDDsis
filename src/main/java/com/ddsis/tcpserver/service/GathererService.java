package com.ddsis.tcpserver.service;

import org.apache.log4j.Logger;

/**
 * 
 * @author jozambrano
 *
 */
public class GathererService {
	
	private static Logger logger = Logger.getLogger(GathererService.class);
	
	/**
	 * Puerta de entrada 
	 * @param input
	 * @return
	 */
	public String gather(String input) {
		if ("FAIL".equals(input)) {
			throw new RuntimeException("Failure Demostration");
		}		
		logger.info("Cliente activo: ");
		logger.info(input);
		return "echo:" + input;
	}

}