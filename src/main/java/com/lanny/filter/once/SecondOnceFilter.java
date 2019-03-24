package com.lanny.filter.once;

import static com.lanny.filter.GlobalConstants.STEP_IN;
import static com.lanny.filter.GlobalConstants.STEP_OUT;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Lanny Yao
 * @date 3/23/2019 7:05 PM
 */
@Slf4j
@WebFilter(urlPatterns = "/api/once/*", filterName = "secondOnceFilter")
public class SecondOnceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.warn(STEP_IN, this.getClass().getName(), "doFilterInternal()");
        // Do the next Filters and invoke the method in Controller
        filterChain.doFilter(request, response);
        log.warn(STEP_OUT, this.getClass().getName(), "doFilterInternal()");
    }
}
