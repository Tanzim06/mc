package com.bz.mc;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Locale;

@Log4j2
@SpringBootApplication
public class McApplication implements CommandLineRunner {
    @Value("${app.data.upload.dir:${user.home}}")
    public String dataUploadDir;

    public static void main(String[] args) {
        SpringApplication.run(McApplication.class, args);
    }

    @Override public void run(String... args) {
        File confFile = new File(dataUploadDir);
        try {
            Files.createDirectories(confFile.toPath());
        } catch (IOException e) {
            log.error("Failed to create upload directory");
        }
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages/messages");
        messageSource.setCacheSeconds(3600); //refresh cache once per hour
        return messageSource;
    }
}
