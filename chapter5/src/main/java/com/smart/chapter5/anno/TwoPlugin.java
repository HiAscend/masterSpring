package com.smart.chapter5.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TwoPlugin
 * Created by zziaa on 2017/10/08.
 */
@Component
@Order(value = 2)
public class TwoPlugin implements Plugin {
}
