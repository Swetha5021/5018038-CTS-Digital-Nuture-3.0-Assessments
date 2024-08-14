package com.swetha.EmployeeManagementSystem.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.repository.primary",
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager")
public class PrimaryDataSourceConfig
{
      @Primary
      @Bean(name = "primaryDataSource")
      @ConfigurationProperties(prefix = "spring.datasource.primary")
      public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
      }
      
      @Primary
      @Bean(name = "primaryEntityManagerFactory")
      public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("primaryDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
            .packages("com.example.entity.primary")
            .persistenceUnit("primary")
            .build();
      }
      
      @Primary
      @Bean(name = "primaryTransactionManager")
      public PlatformTransactionManager primaryTransactionManager(
          @Qualifier("primaryEntityManagerFactory")
          EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
      }
}