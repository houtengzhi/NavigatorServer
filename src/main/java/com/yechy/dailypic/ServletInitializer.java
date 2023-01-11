package com.yechy.dailypic;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Profile;

public class ServletInitializer extends SpringBootServletInitializer {

    @Profile(value = {"war"})
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DailyPicServerApplication.class);
    }
}
