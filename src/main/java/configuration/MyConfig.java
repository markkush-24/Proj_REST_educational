package configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.kushnirmark.spring.project")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver InternalResourceViewResolver = new InternalResourceViewResolver();
        InternalResourceViewResolver.setPrefix("/WEB-INF/view/");
        InternalResourceViewResolver.setSuffix(".jsp");
        return InternalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() { // создаем данный метод для подключения к БД SQL / аналог xml
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("bestuser");
            dataSource.setPassword("bestuser");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.kushnirmark.spring.project.entity");

        Properties hibernateProterties = new Properties();
        hibernateProterties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProterties.setProperty("hibernate.show_sql", "true");
        sessionFactory.setHibernateProperties(hibernateProterties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
