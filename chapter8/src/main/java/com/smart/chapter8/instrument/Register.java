package com.smart.chapter8.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * Register
 *
 * @author ascend
 * @date 2017/11/14 12:47.
 */
public class Register {
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        ClassFileTransformer t = new Transformer();
        instrumentation.addTransformer(t);
    }
}
