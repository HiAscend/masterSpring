package com.smart.chapter17.web;

import com.smart.chapter17.domain.User;
import com.smart.chapter17.domain.UserEditorGlobal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * MyBindingInitializer
 * 优先级@InitBinder > ConversionService > WebBindingInitializer
 *
 * @author zziaa
 * @date 2018/03/22 22:12
 */
public class MyBindingInitializer implements WebBindingInitializer {
    /**
     * Initialize the given DataBinder for the given request.
     *
     * @param binder  the DataBinder to initialize
     * @param request the web request that the data binding happens within
     */
    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(User.class, new UserEditorGlobal());
    }
}
