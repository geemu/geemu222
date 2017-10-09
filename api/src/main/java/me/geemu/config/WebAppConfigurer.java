package me.geemu.config;

import me.geemu.interceptor.AllRequestInterceptor;
import me.geemu.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AllRequestInterceptor allRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(allRequestInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/test/delete")

//                //排除这些路径
//                .excludePathPatterns("/test/")
        ;
        super.addInterceptors(registry);
    }
}