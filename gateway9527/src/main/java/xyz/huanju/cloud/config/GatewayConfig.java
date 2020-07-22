package xyz.huanju.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuanJu
 * @date 2020/7/22 14:17
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();

        routes.route("path_route_h",
                r->r.path("/guonei").uri("http://news.baidu.com/guonei"))
        .route("route_guoji",r->r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }


}
