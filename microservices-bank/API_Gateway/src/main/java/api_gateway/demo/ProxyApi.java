/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api_gateway.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class ProxyApi {
    private final ZuulProperties zuulProperties;

    public ProxyApi(ZuulProperties zuulProperties) {
        this.zuulProperties = zuulProperties;
    }
    
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(){
        return () -> {
            List<SwaggerResource> resources =new ArrayList<>();
            zuulProperties.getRoutes()
                    .values()
                    .forEach(r -> resources.add(createSwaggerResource(r)));
            return resources;
        };
        
        
    } 

    private SwaggerResource createSwaggerResource(ZuulProperties.ZuulRoute r) {
           SwaggerResource swaggerResource =new SwaggerResource();
           swaggerResource.setName(r.getServiceId());
           swaggerResource.setLocation("/"+r.getId()+"/v2/api-docs");
           swaggerResource.setSwaggerVersion("2.0");
           return swaggerResource;
    }
}
