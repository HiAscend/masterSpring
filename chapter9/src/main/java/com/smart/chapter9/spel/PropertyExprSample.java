package com.smart.chapter9.spel;

import com.smart.chapter9.PlaceOfBirth;
import com.smart.chapter9.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * PropertyExprSample
 *
 * @author ascend
 * @date 2017/11/14 15:02.
 */
public class PropertyExprSample {
    public static void main(String[] args) {
        // 1、构造一个对象
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        // 2、构造SpEL解析上下文
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 3、基本属性获取
        String userName = parser.parseExpression("userName").getValue(context, String.class);
        int credits = parser.parseExpression("credits+10").getValue(context, Integer.class);
        System.out.println("userName = " + userName);
        System.out.println("credits = " + credits);

        // 4、嵌套对象属性值获取
        String city = parser.parseExpression("placeOfBirth.city").getValue(context, String.class);
        System.out.println("city = " + city);
    }
}
