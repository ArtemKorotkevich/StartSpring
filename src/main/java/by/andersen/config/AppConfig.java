package by.andersen.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("by.andersen.dao"),
        @ComponentScan("by.andersen.service")})
public class AppConfig {

    private final Environment env;

    @Autowired
    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.driver"));
        dataSource.setUrl(env.getProperty("mysql.url"));
        dataSource.setUsername(env.getProperty("mysql.user"));
        dataSource.setPassword(env.getProperty("mysql.password"));
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties props = new Properties();
        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(DIALECT, env.getProperty("hibernate.dialect"));
        props.put(AUTOCOMMIT, env.getProperty("hibernate.connection.autocommit"));


        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("by.andersen.model");
        factoryBean.setDataSource(dataSource());

        return factoryBean;
    }


}