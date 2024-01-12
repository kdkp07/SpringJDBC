package in.spring.jdbc.resources;

import in.spring.jdbc.dao.StudentDao;
import in.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"in.spring.jdbc.dao"})
public class springConfig {

    // i will write beans here

    @Bean
    public DriverManagerDataSource createDs(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("Kuldeep@123");
        return ds;
    }

    @Bean
    public JdbcTemplate createTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(createDs());
        return jdbcTemplate;
    }

}
