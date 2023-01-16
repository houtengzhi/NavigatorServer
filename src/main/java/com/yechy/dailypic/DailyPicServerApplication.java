package com.yechy.dailypic;

import com.yechy.dailypic.controller.AccountController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyPicServerApplication {

	private static Logger logger = LoggerFactory.getLogger(DailyPicServerApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(DailyPicServerApplication.class, args);
		} catch (Exception e){
			e.printStackTrace();
			logger.warn("启动异常", e.getMessage());
		}
	}

}
