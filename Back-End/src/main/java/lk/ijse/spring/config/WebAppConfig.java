package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.FileUploadController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {FileUploadController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000);
        return multipartResolver;
    }
}
