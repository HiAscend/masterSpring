package com.smart.chapter7.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.Joinpoint;

/**
 * GreetingInterceptor
 *
 * @author ascend
 * @date 2017/10/31 17:04
 */
public class GreetingInterceptor implements MethodInterceptor {
    /**
     * Implement this method to perform extra treatments before and
     * after the invocation. Polite implementations would certainly
     * like to invoke {@link Joinpoint#proceed()}.
     *
     * @param invocation the method invocation joinpoint
     * @return the result of the call to {@link
     * Joinpoint#proceed()}, might be intercepted by the
     * interceptor.
     * @throws Throwable if the interceptors or the
     *                   target-object throws an exception.
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
        Object obj = invocation.proceed();
        System.out.println("Please enjoy yourself!");
        return obj;
    }
}
