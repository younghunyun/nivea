package kr.bespinlab.nivea.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Slf4j
@Component
public class NiveaScheduler {

//    @Scheduled(cron = "*/5 * * * * *")
    @Scheduled(cron = "#{@schedulerLogMsg}")
    public void logMessage() {
        log.info("Scheduler | logMessage: {}", Calendar.getInstance().getTime());
    }
}
