package com.lanny.filter.zuul;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

/**
 * Calculate content length for response body
 *
 * @author Lanny Yao
 * @date 3/25/2019 3:09 PM
 */
@Slf4j
@Component
public class PostZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        return RequestContext.getCurrentContext().getOriginResponseHeaders().stream()
                .map(Pair::first)
                .noneMatch("content-length"::equals);
    }

    @Override
    public Object run() {
        InputStream stream = RequestContext.getCurrentContext().getResponseDataStream();
        try {
            String body = IOUtils.toString(stream);
            log.warn("Response -> {}", body);
            RequestContext.getCurrentContext().getResponse().setContentLength(body.length());
            RequestContext.getCurrentContext().setResponseBody(body);
        } catch (IOException e) {
            log.error("Error:　", e);
        }

        return null;
    }
}
