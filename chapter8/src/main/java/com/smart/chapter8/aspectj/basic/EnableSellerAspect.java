package com.smart.chapter8.aspectj.basic;

import com.smart.chapter8.Seller;
import com.smart.chapter8.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * EnableSellerAspect
 *
 * @author ascend
 * @date 2017/11/9 14:09.
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.smart.chapter8.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;
}
