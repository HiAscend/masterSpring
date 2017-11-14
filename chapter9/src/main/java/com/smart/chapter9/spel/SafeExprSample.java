package com.smart.chapter9.spel;

import com.smart.chapter9.PlaceOfBirth;
import com.smart.chapter9.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * SafeExprSample
 *
 * @author ascend
 * @date 2017/11/14 16:13.
 */
public class SafeExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setCredits(100);
        user.setLastVisit(new Date());
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        String city = parser.parseExpression("placeOfBirth?.city").getValue(context, String.class);
        System.out.println("city = " + city);

        // 1、将PlaceOfBirth对象设置为null
        user.setPlaceOfBirth(null);

        // 2、不会抛出异常
        city = parser.parseExpression("placeOfBirth?.city").getValue(context, String.class);
        System.out.println("city = " + city);
    }
}
