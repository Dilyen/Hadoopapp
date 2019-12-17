package io.turntabl.Hadoopapp;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableSwagger2
@SpringBootApplication
public class HadoopappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HadoopappApplication.class, args);
    }

    @Configuration
    @Profile("default")
     static class HiveConfig {
        Logger logger = LoggerFactory.getLogger(HiveConfig.class);

        @Value("${hiveuri}")
        private String databaseUri;

        @Value("${hiveusername}")
        private String username;

        @Value("${hivepassword}")
        private String password;

        @Bean
        public DataSource dataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(databaseUri);
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        }
    }

}
