package com.yechy.dailypic.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ResponseUtil {

//    public static ResponseResult<Object> success(Object object) {
//        ResponseResult<Object> result = new ResponseResult<>();
//        result.setCode(HttpStatus.OK.value());
//        result.setMessage("Success");
//        result.setData(object);
//        return result;
//    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage("Success");
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> success() {
        return success(null);
    }
}
