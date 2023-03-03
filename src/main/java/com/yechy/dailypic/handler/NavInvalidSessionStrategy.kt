package com.yechy.dailypic.handler

import com.fasterxml.jackson.databind.ObjectMapper
import com.yechy.dailypic.util.ResponseUtil
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.web.session.InvalidSessionStrategy

class NavInvalidSessionStrategy : InvalidSessionStrategy {

    @Autowired
    lateinit var objectMapper: ObjectMapper
    override fun onInvalidSessionDetected(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "application/json;charset=UTF-8"
        response.writer.write(objectMapper.writeValueAsString(ResponseUtil.success("session timeout")))
    }
}