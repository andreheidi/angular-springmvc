package me.moriya.config;

import me.moriya.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by andre on 6/20/16.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {PersonRepository.class})
class RepositoryConfig {

    @Bean
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory entityManagerFactory = this.entityManagerFactory().getObject();
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        factory.setPackagesToScan("me.moriya.entity");
        factory.setDataSource(this.dataSource());
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factory;
    }

    private DataSource dataSource() {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource("java:/postgres");
    }

}