package kr.bespinlab.nivea.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Slf4j
public class PropertyConfiguration {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ResourceLoader resourceLoader;

    private String uploadServerPath;
    private String uploadResourcePath;
    private String uploadFilePrefix;

    private String thumbnailFileEnabled;

    private String schedulerLogMsg;

    private boolean local;
    private boolean dev;
    private boolean prod;

    @PostConstruct
    public void init() {
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();

        String activeProfile = "local";
        if (ObjectUtils.isNotEmpty(activeProfiles)) {
            activeProfile = activeProfiles[0];
        }

        log.info("Load Properties - active profiles: {}", activeProfile);

        String resourcePath = String.format("classpath:properties/global-%s.properties", activeProfile);

        try {
            Resource resource = resourceLoader.getResource(resourcePath);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            this.uploadServerPath = properties.getProperty("uploadFile.serverPath");
            this.uploadResourcePath = properties.getProperty("uploadFile.resourcePath");
            this.uploadFilePrefix = properties.getProperty("uploadFile.prefix");
            this.thumbnailFileEnabled = properties.getProperty("thumbnailFile.enabled");
            this.schedulerLogMsg = properties.getProperty("scheduler.cron.logMsg");

            this.local = activeProfile.equals("local");
            this.dev = activeProfile.equals("dev");
            this.prod = activeProfile.equals("prod");
        } catch (Exception e) {
            log.error("EXCEPTION: {}", e.getMessage());
        }
    }

    public String getUploadServerPath() {
        return uploadServerPath;
    }

    public String getUploadResourcePath() {
        return uploadResourcePath;
    }

    public String getUploadFilePrefix() {
        return uploadFilePrefix;
    }

    public String getSchedulerLogMsg() {
        return schedulerLogMsg;
    }

    public String getThumbnailFileEnabled() {
        return thumbnailFileEnabled;
    }

    public boolean isLocal() {
        return local;
    }

    public boolean isDev() {
        return dev;
    }

    public boolean isProd() {
        return prod;
    }
}
