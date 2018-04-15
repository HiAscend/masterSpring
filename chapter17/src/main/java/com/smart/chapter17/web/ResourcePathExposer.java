package com.smart.chapter17.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * ResourcePathExposer
 *
 * @author zziaa
 * @date 2018/04/15 8:08
 */
public class ResourcePathExposer implements ServletContextAware {
    private ServletContext servletContext;
    private String resourceRoot;

    public void init() {
        // 在实际应用中，可以在外部属性文件或者数据库中保存应用发布的版本号，在此处获取之。此处仅仅提供了一个模拟值
        String version = "1.2.2";
        resourceRoot = "/resource-" + version;
        // 将资源逻辑路径暴露到ServletContext的属性列表中
        getServletContext().setAttribute("resourceRoot", getServletContext().getContextPath() + resourceRoot);

    }

    /**
     * Set the {@link ServletContext} that this object runs in.
     * <p>Invoked after population of normal bean properties but before an init
     * callback like InitializingBean's {@code afterPropertiesSet} or a
     * custom init-method. Invoked after ApplicationContextAware's
     * {@code setApplicationContext}.
     *
     * @param servletContext ServletContext object to be used by this object
     * @see InitializingBean#afterPropertiesSet
     * @see ApplicationContextAware#setApplicationContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public String getResourceRoot() {
        return resourceRoot;
    }
}
