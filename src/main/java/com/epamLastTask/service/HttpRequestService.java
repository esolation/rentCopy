package com.epamLastTask.service;

import javax.servlet.http.HttpServletRequest;

public interface HttpRequestService {
    boolean checkUrlPath(HttpServletRequest request);
    void saveUrlPath(HttpServletRequest request);

}
