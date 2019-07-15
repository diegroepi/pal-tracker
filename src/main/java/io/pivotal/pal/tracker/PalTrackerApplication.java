package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.TimeZone;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);

    }

    // SpringBoot magic - if there is a DataSource in code Spring will try and inject it
    @Bean
    public TimeEntryRepository getTimeEntryRepository(DataSource dataSource)
    {
       return new JdbcTimeEntryRepository(dataSource);
    }




}
