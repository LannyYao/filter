package com.lanny.filter.zuul;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Service;

/**
 * @author Lanny Yao
 * @date 3/24/2019 6:31 PM
 */
@Slf4j
@Service
public class RouterZuulFilter extends ZuulFilter {

    private static final String X_FORWARDED_PREFIX = "x-forwarded-prefix";

    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set(SERVICE_ID_KEY, null);
        String routeHost = "http://localhost:5050";
        try {
            ctx.setRouteHost(new URL(routeHost));
        } catch (MalformedURLException ex) {
            throw new IllegalStateException("Target URL is malformed", ex);
        }

        log.warn("Request will be routed to route host: {}", routeHost);

        ctx.put(FilterConstants.REQUEST_URI_KEY, "/api/v3/jpa");
        final String requestURI = ctx.getRequest().getRequestURI();

        log.error("Request uri: {}", requestURI);
//        ctx.addZuulRequestHeader(X_FORWARDED_PREFIX, "/api/v3/");

        return null;
    }
}
