package com.lanny.filter.filter;

import static com.lanny.filter.GlobalConstants.STEP_IN;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 通过过滤器的名字，进行顺序的约定，比如LogFilter和AuthFilter，此时AuthFilter就会比LogFilter先执行，因为首字母A比L前面
 * @see Order the less, the earlier
 * @author Lanny Yao
 * @date 3/21/2019 3:19 PM
 */
@Slf4j
@Component
@Order(1)
@WebFilter(urlPatterns = "/api/filter/*", filterName = "simpleFilter")
public class SimpleFilter implements Filter {

//    @Bean
//    public Filter simpleFilter() {
//        return new SimpleFilter();
//    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
//        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
//        registration.setFilter(simpleFilter());
//        //过滤器名称
//        registration.setName("simpleFilter");
//        //拦截路径
//        registration.addUrlPatterns("/*");
//        //设置顺序
//        registration.setOrder(10);
//        return registration;
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.warn("SimpleFilter init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.warn(STEP_IN, this.getClass().getName(), "doFilter()");
        // Do the next Filters and invoke the method in Controller
        chain.doFilter(request, response);
        log.warn(STEP_IN, this.getClass().getName(), "doFilter()");

    }
    @Override
    public void destroy() {

        log.warn("SimpleFilter destroy()");
    }
}
