package com.smart.chapter9.spel;

import com.smart.chapter9.PlaceOfBirth;
import com.smart.chapter9.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * ElvisExprSample
 *
 * @author ascend
 * @date 2017/11/14 16:33.
 */
public class ElvisExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setCredits(100);
        user.setLastVisit(new Date());
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        String userNmae = parser.parseExpression("userName?:'用户名为空'").getValue(context, String.class);
        System.out.println("userNmae = " + userNmae);
        user.setUserName(null);
        userNmae = parser.parseExpression("userName?:'用户名为空'").getValue(context, String.class);
        System.out.println("userNmae = " + userNmae);
    }
}
