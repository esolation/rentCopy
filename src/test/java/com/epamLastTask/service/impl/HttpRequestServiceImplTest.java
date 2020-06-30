package com.epamLastTask.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class HttpRequestServiceImplTest {
    @Autowired
    private HttpRequestServiceImpl requestService;
    @Test
    void shouldCheckIfUrlPathContainsLoginOrRegister() {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

        httpServletRequest.addHeader("referer","http://localhost:8080/login");
        Assert.assertFalse(requestService.checkUrlPath(httpServletRequest));
    }
}