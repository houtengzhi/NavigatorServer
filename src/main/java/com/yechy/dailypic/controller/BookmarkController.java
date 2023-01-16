package com.yechy.dailypic.controller;

import com.yechy.dailypic.entity.Bookmark;
import com.yechy.dailypic.service.IBookmarkService;
import com.yechy.dailypic.util.ResponseResult;
import com.yechy.dailypic.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookmarkController {

    @Autowired
    private IBookmarkService bookmarkService;

    @PostMapping(value = "/bookmark")
    public ResponseResult addBookmark(@RequestBody Bookmark bookmark) {
        int ret = bookmarkService.addBookmark(bookmark);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/bookmarkList", method = RequestMethod.GET)
    @ResponseBody
    public List<Bookmark> getBookmarkList() {
        String accountId = "";
        return bookmarkService.queryBookmarkList(accountId);
    }
}
