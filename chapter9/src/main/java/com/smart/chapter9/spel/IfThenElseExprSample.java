package com.smart.chapter9.spel;

import com.smart.chapter9.PlaceOfBirth;
import com.smart.chapter9.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * IfThenElseExprSample
 *
 * @author ascend
 * @date 2017/11/14 16:26.
 */
public class IfThenElseExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        // 三元操作表达式
        String expression = "userName=='tom'?credits+10:credits";
        Integer credits = parser.parseExpression(expression).getValue(context, Integer.class);
        System.out.println("credits = " + credits);
    }
}
