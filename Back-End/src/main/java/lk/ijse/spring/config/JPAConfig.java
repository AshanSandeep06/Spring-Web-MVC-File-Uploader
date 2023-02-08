package lk.ijse.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories()
public class JPAConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean(DataSource dataSource, JpaVendorAdapter vendor){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPackagesToScan("lk.ijse.spring.entity");
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendor);
        return factory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource bds = new DriverManagerDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/File_upload-db?createDatabaseIfNotExist=true");
        bds.setUsername("root");
        bds.setPassword("1234");
        return bds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateVendor = new HibernateJpaVendorAdapter();
        hibernateVendor.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        hibernateVendor.setDatabase(Database.MYSQL);
        hibernateVendor.setGenerateDdl(true);
        hibernateVendor.setShowSql(true);
        return hibernateVendor;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager();
    }
}
