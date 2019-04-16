package com.lanny.filter.zuul;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lanny Yao
 * @date 3/24/2019 8:25 PM
 */
@Getter
@Setter
public class RouterClientDetails {

    private String host;

    private String originEndpoint;

    private String passThoughUri;
}
