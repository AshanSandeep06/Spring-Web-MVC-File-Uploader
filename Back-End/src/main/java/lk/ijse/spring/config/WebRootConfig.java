package lk.ijse.spring.config;

import lk.ijse.spring.service.impl.FileServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {FileServiceImpl.class})
public class WebRootConfig {

}
