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
    public Map<String, Object> filter(){

        String methodName = "filter()";
        log.warn(STEP_IN, this.getClass().getName(), methodName);

        Map<String, Object> res = getResponseByMethod(methodName);

        log.warn(STEP_OUT, this.getClass().getName(), methodName);
        return res;
    }

    @GetMapping(value = "/interceptor")
    public Map<String, Object> interceptor() {

        String methodName = "interceptor()";
        log.warn(STEP_IN, this.getClass().getName(), methodName);

        Map<String, Object> res = getResponseByMethod(methodName);

        log.warn(STEP_OUT, this.getClass().getName(), methodName);
        return res;
    }

    @GetMapping(value = "/both")
    public Map<String, Object> both() {

        String methodName = "both()";
        log.warn(STEP_IN, this.getClass().getName(), methodName);

        Map<String, Object> res = getResponseByMethod(methodName);

        log.warn(STEP_OUT, this.getClass().getName(), methodName);
        return res;
    }

    @GetMapping(value = "/once")
    public Map<String, Object> once(){

        String methodName = "once()";
        log.warn(STEP_IN, this.getClass().getName(), methodName);

        Map<String, Object> res = getResponseByMethod(methodName);

        log.warn(STEP_OUT, this.getClass().getName(), methodName);
        return res;
    }

    private Map<String, Object> getResponseByMethod(String methodName) {
        Map<String, Object> res = new HashMap<>();
        res.put("result", "successful");
        res.put("Method", methodName);

        return res;
    }
}
