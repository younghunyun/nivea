package kr.bespinlab.nivea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfiguration {

    @Autowired
    private PropertyConfiguration config;

    @Bean
    public String schedulerLogMsg() {
        return config.getSchedulerLogMsg();
    }
}
