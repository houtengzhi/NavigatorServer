package com.yechy.dailypic.service;

import com.yechy.dailypic.entity.Bookmark;

import java.util.List;

public interface IBookmarkService {
    void createTable();
    int addBookmark(Bookmark bookmark);
    int updateBookmark(Bookmark bookmark);
    int deleteBookmark(Bookmark bookmark);
    List<Bookmark> queryBookmarkList(String accountId);
}
