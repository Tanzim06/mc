package com.bz.mc;



/**
 * User: SHI
 * Date: 8/12/19
 * Time: 11:07 AM
 */
import com.bz.mc.converter.form.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AppWebConfig implements WebMvcConfigurer {

    @Override public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new OfficeTypeConverter());
       registry.addConverter(new UserStatusConverter());
       // registry.addConverter(new UserTypeConverter());
//        registry.addConverter(new LoanDisbursementModeConverter());
//        registry.addConverter(new RelationConverter());
//        registry.addConverter(new DocumentSourceConverter());
       // registry.addConverter(new SelectionStateConverter());
       // registry.addConverter(new RecommendationStateConverter());
        registry.addConverter(new GenderConverter());
        registry.addConverter(new OriginConverter() );

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/assets/**",
                "/images/**")
                .addResourceLocations(
                        "classpath:/static/assets/",
                        "classpath:/static/images/");
    }

}