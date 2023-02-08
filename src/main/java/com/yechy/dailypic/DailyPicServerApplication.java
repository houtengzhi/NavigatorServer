package com.yechy.dailypic;

import com.yechy.dailypic.controller.AccountController;
import com.yechy.dailypic.entity.Bookmark;
import com.yechy.dailypic.service.IAccountService;
import com.yechy.dailypic.service.IBookmarkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DailyPicServerApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(DailyPicServerApplication.class);

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IBookmarkService bookmarkService;

	public static void main(String[] args) {
		try {
			SpringApplication.run(DailyPicServerApplication.class, args);
		} catch (Exception e){
			e.printStackTrace();
			logger.warn("启动异常", e.getMessage());
		}
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.createTable();
		bookmarkService.createTable();
		for (Bookmark bookmark : getBookmarkList()) {
//			bookmarkService.addBookmark(bookmark);
		}
	}

	public List<Bookmark> getBookmarkList() {
		Bookmark bookmark = new Bookmark();
		bookmark.setId(1);
		bookmark.setSiteName("Baidu");
		bookmark.setSiteUrl("www.baidu.com");
		bookmark.setAccountId("id_123456");
		bookmark.setCategoryName("Search");
		List<Bookmark> list = new ArrayList<>();
		list.add(bookmark);

		bookmark = new Bookmark();
		bookmark.setId(2);
		bookmark.setSiteName("Google");
		bookmark.setSiteUrl("www.google.com");
		bookmark.setAccountId("id_123456");
		bookmark.setCategoryName("Search");
		list.add(bookmark);

		bookmark = new Bookmark();
		bookmark.setId(2);
		bookmark.setSiteName("Moxo");
		bookmark.setSiteUrl("www.moxo.com");
		bookmark.setAccountId("id_123456");
		bookmark.setCategoryName("Company");
		list.add(bookmark);
		return list;
	}
}
