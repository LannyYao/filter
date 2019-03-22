package com.lanny.filter.interceptor;

import static com.lanny.filter.GlobalConstants.STEP_IN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lanny Yao
 * @date 3/22/2019 9:50 AM
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 请求前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.warn(STEP_IN, this.getClass().getName(), "preHandle()");

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (auth == null) {
            response.sendError(403, "Missing token");
            return false;  //If just send error instead of returning false here, it'll still invoke the method in the
            // Controller
        }

        //返回 false 则请求中断
        return true;
    }

    /**
     * 请求后调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        log.warn(STEP_IN, this.getClass().getName(), "postHandle()");
    }

    /**
     * 请求调用完成后回调方法，即在视图渲染完成后回调
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        log.warn(STEP_IN, this.getClass().getName(), "afterCompletion()");
    }

}
