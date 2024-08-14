package com.swetha.EmployeeManagementSystem.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement

@EnableJpaRepositories(basePackages = "com.example.repository.secondary",
    entityManagerFactoryRef = "secondaryEntityManagerFactory",
    transactionManagerRef = "secondaryTransactionManager")
public class SecondaryDataSourceConfig
{
      @Bean(name = "secondaryDataSource")
      @ConfigurationProperties(prefix = "spring.datasource.secondary")
      public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
      }
      
      @Bean(name = "secondaryEntityManagerFactory")
      public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("secondaryDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
            .packages("com.example.entity.secondary")
            .persistenceUnit("secondary")
            .build();
      }
      
      @Bean(name = "secondaryTransactionManager")
      public PlatformTransactionManager secondaryTransactionManager(
          @Qualifier("secondaryEntityManagerFactory")
          EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
      }
}