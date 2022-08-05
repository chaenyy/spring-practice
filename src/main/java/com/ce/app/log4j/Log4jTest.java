package com.ce.app.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
	static final Logger log = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		log.fatal("fatal!");
		log.error("error!");
		log.warn("warn!");
		log.info("info!");
		log.debug("debug!");
		log.trace("trace!");
	}
}
