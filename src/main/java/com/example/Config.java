package com.example;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Config implements WebMvcConfigurer {

    @Bean(name = "turboStreamViewResolver")
    public ViewResolver turboStreamViewResolver() {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".vnd.turbo-stream.mustache");
        resolver.setOrder(1);
        resolver.setContentType("text/vnd.turbo-stream.html");
        resolver.setCharset("UTF-8");
        return resolver;
    }

    @Bean(name = "htmlViewResolver")
    public ViewResolver htmlViewResolver() {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".mustache");
        resolver.setOrder(2);
        resolver.setContentType(MediaType.TEXT_HTML_VALUE);
        resolver.setCharset("UTF-8");
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(turboStreamViewResolver());
        registry.viewResolver(htmlViewResolver());
    }
}
