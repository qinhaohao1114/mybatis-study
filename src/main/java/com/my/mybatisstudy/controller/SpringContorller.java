package com.my.mybatisstudy.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/test/threadLocal")
@RestController
public class SpringContorller {

    ThreadLocal<Long> local = new ThreadLocal<>();

    @GetMapping("/set")
    public Long set(HttpServletRequest request) {
        String str = request.getParameter("str");
        if (StringUtils.isEmpty(str)) {
            local.set(null);
            return local.get();
        }
        local.set(Long.valueOf(str));
        return local.get();
    }
}
