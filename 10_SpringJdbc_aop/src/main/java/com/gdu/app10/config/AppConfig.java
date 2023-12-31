package com.gdu.app10.config;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;
 

@PropertySource(value = "classpath:application.properties")     //프로퍼티 읽어들이는 어노테이션 ->environment를 스프링이 제작해서 갖고있음.
                                                        // 그걸 불러들이는 작업을 해 주어야함.(@Autowired)
@EnableAspectJAutoProxy  // @Aspect동작 수행
@Configuration
public class AppConfig {
  
  @Autowired
  private Environment env;
  
  
  // DataSource : CP(Connection Pool)을 처리하는 javax.sql.DataSource 인터페이스
  @Bean
  public DataSource dataSource() {
    // DriverManagerDataSource : CP(Connection Pool)을 처리하는 스프링 클래스
    DriverManagerDataSource dataSource = new DriverManagerDataSource();  
    dataSource.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
    dataSource.setUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
    dataSource.setUsername(env.getProperty("spring.datasource.hikari.username"));
    dataSource.setPassword(env.getProperty("spring.datasource.hikari.password"));
    
    return dataSource;
  }
  
  // JdbcTemplate : Jdbc를 처리하는 스프링 클래스(Connection, PreparedStatement, ResultSet 처리 담당)
  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }
  
  // TransactionManager : 트랜잭션을 처리하는 스프링 인터페이스
  @Bean
  public TransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }
  
  
  
  /* 지금부터 AOP를 이용한 트랜잭션 처리를 위해 필요한 Bean */
  
  
  
  // TransactionInterceptor : 트랜잭션 처리를 위해 언제 rolloback 할 것인지 정의하는 스프링 클래스
  @Bean
  public TransactionInterceptor transactionInterceptor() {
    
    // 규칙
    RuleBasedTransactionAttribute ruleBasedTransactionAttribute = new RuleBasedTransactionAttribute();
    ruleBasedTransactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
    
    // 만든 규칙을 트랜잭션 인터셉터가 요구하는 타입으로 변환 
    MatchAlwaysTransactionAttributeSource matchAlwaysTransactionAttributeSource = new MatchAlwaysTransactionAttributeSource();
    matchAlwaysTransactionAttributeSource.setTransactionAttribute(ruleBasedTransactionAttribute);  
    
    // 반환
    return new TransactionInterceptor(transactionManager(), matchAlwaysTransactionAttributeSource);
    
  }
  
  // Advisor : 트랜잭션 동작을 언제 할 것인지 결정하는 스프링 인터페이스
  @Bean
  public Advisor advisor() {
    
    // 포인트컷 
    AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
    aspectJExpressionPointcut.setExpression("execution(* com.gdu.app10.service.*Impl.*(..))");
    
    // 어드바이스 반환
    return new DefaultPointcutAdvisor(aspectJExpressionPointcut, transactionInterceptor());
    
  }
  
  
}