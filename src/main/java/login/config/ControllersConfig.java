package login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ControllersConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        
        registry.addViewController("/aparts").setViewName("aparts");
        registry.addViewController("/apart/orders/").setViewName("apart/orders");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/choose").setViewName("choose");
        registry.addViewController("/forbidden").setViewName("forbidden");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/get_apparts/").setViewName("get_apparts");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/").setViewName("aparts");

    }

}
