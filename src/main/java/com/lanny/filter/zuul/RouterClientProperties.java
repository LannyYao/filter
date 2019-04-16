package com.lanny.filter.zuul;

import static com.lanny.filter.zuul.RouterClientProperties.BEAN_NAME;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lanny Yao
 * @date 3/24/2019 8:23 PM
 */
@Configuration(value = BEAN_NAME)
public class RouterClientProperties {

    public static final String BEAN_NAME = "routerClientProperties";

    @Getter
    @Setter
    private Map<String, RouterClientDetails> clients = new HashMap<>();
}
