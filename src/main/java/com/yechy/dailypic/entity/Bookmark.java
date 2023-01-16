package com.yechy.dailypic.entity;

import java.io.Serializable;

public class Bookmark implements Serializable {

    int id;
    String accountId;
    String siteName;
    String siteUrl;
    String logoUrl;
    int categoryId;
    String categoryName;
    int categoryOrder;
}
