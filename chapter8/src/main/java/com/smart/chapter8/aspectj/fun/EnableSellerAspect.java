package com.smart.chapter8.aspectj.fun;

import com.smart.chapter8.Seller;
import com.smart.chapter8.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

/**
 * TestAspect
 *
 * @author ascend
 * @date 2017/11/9 14:30.
 */
@Aspect
public class EnableSellerAspect implements Ordered{

    @DeclareParents(value = "com.smart.chapter8.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 2;
    }
}
