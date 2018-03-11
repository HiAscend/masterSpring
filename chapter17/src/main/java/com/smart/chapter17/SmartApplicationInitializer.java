package com.smart.chapter17;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * SmartApplicationInitializer
 * 配置此类，与web.xml配置效果相同
 *
 * @author ascend
 * @date 2018/03/04 19:45
 */
public class SmartApplicationInitializer /*implements WebApplicationInitializer*/ {
    /**
     * Configure the given {@link ServletContext} with any servlets, filters, listeners
     * context-params and attributes necessary for initializing this web application. See
     * examples {@linkplain WebApplicationInitializer above}.
     *
     * @param servletContext the {@code ServletContext} to initialize
     * @throws ServletException if any call against the given {@code ServletContext}
     *                          throws a {@code ServletException}
     */
//    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("*.html");*/
    }



}
