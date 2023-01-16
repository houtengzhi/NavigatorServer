package com.yechy.dailypic.mapper;

import com.yechy.dailypic.entity.Bookmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookmarkMapper {

    int addBookmark(Bookmark bookmark);
    int updateBookmark(Bookmark bookmark);
    int deleteBookmark(Bookmark bookmark);
    List<Bookmark> queryBookmarkList(String accountId);
}
