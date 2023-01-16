package com.yechy.dailypic.service;

import com.yechy.dailypic.entity.Bookmark;
import com.yechy.dailypic.mapper.BookmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookmarkService")
public class BookmarkServiceImpl implements IBookmarkService{
    @Autowired
    private BookmarkMapper bookmarkMapper;
    @Override
    public int addBookmark(Bookmark bookmark) {
        return bookmarkMapper.addBookmark(bookmark);
    }

    @Override
    public int updateBookmark(Bookmark bookmark) {
        return bookmarkMapper.updateBookmark(bookmark);
    }

    @Override
    public int deleteBookmark(Bookmark bookmark) {
        return bookmarkMapper.deleteBookmark(bookmark);
    }

    @Override
    public List<Bookmark> queryBookmarkList(String accountId) {
        return bookmarkMapper.queryBookmarkList(accountId);
    }
}
