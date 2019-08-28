package io.pivotal.pal.tracker;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class PalTrackerApplication {

    private String dateFormat1="mm/dd/yyyy";
    private String dateFormat2="yyyy-mm-dd";

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class,args);
    }

    @Bean
    public TimeEntryRepository timeEntryRepository()
    {
        return new JdbcTimeEntryRepository(mysqlDataSource());
    }


    public MysqlDataSource mysqlDataSource(){
        MysqlDataSource mysqlDataSource= new MysqlDataSource();
        mysqlDataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        return mysqlDataSource;
    }



}
