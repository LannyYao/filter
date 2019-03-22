package com.lanny.filter.controller;

import static com.lanny.filter.GlobalConstants.STEP_IN;
import static com.lanny.filter.GlobalConstants.STEP_OUT;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lanny Yao
 * @date 3/21/2019 3:15 PM
 */
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ActionController {

    @GetMapping(value = "/filter")
    public Map<String, Object> filter() {

        log.warn(STEP_IN, this.getClass().getName(), "filter()");

        Map<String, Object> res = new HashMap<>();
        res.put("result", "successful");
        res.put("Method", "filter()");

        log.warn(STEP_OUT, this.getClass().getName(), "filter()");
        return res;
    }

    @GetMapping(value = "/interceptor")
    public Map<String, Object> interceptor() {

        log.warn(STEP_IN, this.getClass().getName(), "interceptor()");

        Map<String, Object> res = new HashMap<>();
        res.put("result", "successful");
        res.put("Method", "interceptor()");

        log.warn(STEP_OUT, this.getClass().getName(), "interceptor()");
        return res;
    }
}
