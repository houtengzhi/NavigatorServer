package com.yechy.dailypic.controller;

import com.yechy.dailypic.entity.Account;
import com.yechy.dailypic.entity.Bookmark;
import com.yechy.dailypic.entity.Category;
import com.yechy.dailypic.service.IAccountService;
import com.yechy.dailypic.service.IBookmarkService;
import com.yechy.dailypic.util.ResponseResult;
import com.yechy.dailypic.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookmarkController {

    private final Logger logger = LoggerFactory.getLogger(BookmarkController.class);

    @Autowired
    private IBookmarkService bookmarkService;

    @Autowired
    private IAccountService accountService;

    @PostMapping(value = "/bookmark")
    public ResponseResult addBookmark(@RequestBody Bookmark bookmark, Principal principal) {
        Account account = accountService.queryAccountByName(principal.getName());
        bookmark.setAccountId(account.getAccountId());
        int ret = bookmarkService.addBookmark(bookmark);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/bookmarks", method = RequestMethod.GET)
    @ResponseBody
    public List<Bookmark> getBookmarkList() {
        String accountId = "";
        return bookmarkService.queryBookmarkList(accountId);
    }

    @GetMapping(value = "/index")
    public String index(Model m, Principal principal) {
        String name = principal.getName();
        Account account = accountService.queryAccountByName(name);
        List<Bookmark> bookmarkList = bookmarkService.queryBookmarkList(account.getAccountId());
        m.addAttribute("bookmarkList", bookmarkList);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Search"));
        categoryList.add(new Category("Company"));
        m.addAttribute("categoryList", categoryList);
        return "index";
    }
}
