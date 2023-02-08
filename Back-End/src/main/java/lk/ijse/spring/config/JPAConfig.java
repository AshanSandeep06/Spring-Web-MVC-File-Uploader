package lk.ijse.spring.config;

import lk.ijse.spring.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = FileRepo.class)
@PropertySource("classpath:application.properties")
public class JPAConfig {
    @Autowired
    private Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter vendor) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPackagesToScan(environment.getRequiredProperty("config.entity"));
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendor);
        return factory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource bds = new DriverManagerDataSource();
        bds.setDriverClassName(environment.getRequiredProperty("config.driver"));
        bds.setUrl(environment.getRequiredProperty("config.url"));
        bds.setUsername(environment.getRequiredProperty("config.username"));
        bds.setPassword(environment.getRequiredProperty("config.password"));
        return bds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateVendor = new HibernateJpaVendorAdapter();
        hibernateVendor.setDatabasePlatform(environment.getRequiredProperty("config.dialect"));
        hibernateVendor.setDatabase(Database.MYSQL);
        hibernateVendor.setGenerateDdl(true);
        hibernateVendor.setShowSql(true);
        return hibernateVendor;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager();
    }
}
