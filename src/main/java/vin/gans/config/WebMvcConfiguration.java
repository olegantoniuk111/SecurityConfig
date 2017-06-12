//package vin.gans.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//
//import java.util.Locale;
//
//@Configuration
//public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    HandlerInterceptor yourInjectedInterceptor;
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.ENGLISH);
//        return slr;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        registry.addInterceptor(localeChangeInterceptor);
//    }
//    @Bean
//    public MessageSource messageSource() {
//    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//    messageSource.setBasename("classpath:messages");
//    messageSource.setUseCodeAsDefaultMessage(true);
//    messageSource.setDefaultEncoding("UTF-8");
//    messageSource.setCacheSeconds(0);
//    return messageSource;
//    }
//
//}
