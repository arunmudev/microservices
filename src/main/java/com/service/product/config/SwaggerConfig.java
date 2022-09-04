package com.service.product.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jdk.javadoc.doclet.Doclet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getApi(){
     return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Product Service Application API")
                        .description("All products regsistered here")
                        .termsOfService("terms")
                        .contact(new Contact().email("smaple@gmail.com"))
                        .license(new License().name("GNU"))
                        .version("1.0"))
                .schemaRequirement("prodcut service",new SecurityScheme()
                        .scheme("basic")
                        .type(SecurityScheme.Type.HTTP)
                        .in(SecurityScheme.In.HEADER));
    }
}
