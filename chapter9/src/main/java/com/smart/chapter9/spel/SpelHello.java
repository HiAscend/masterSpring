package com.smart.chapter9.spel;

import com.smart.chapter9.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * SpelHello
 *
 * @author ascend
 * @date 2017/11/14 14:04.
 */
public class SpelHello {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello'+'World'");
        String message = expression.getValue(String.class);
        System.out.println("message = " + message);
    }

    @Test
    public void testCallMethod() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'HelloWorld'.concat('!')");
        String message = expression.getValue(String.class);
        System.out.println("message = " + message);
    }

    @Test
    public void testCallAttribute() {
        User user = new User();
        user.setUserName("tom");
        user.setCredits(100);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        String userName = parser.parseExpression("userName").getValue(context, String.class);
        System.out.println("userName = " + userName);
    }

    @Test
    public void testSimple() {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(simple);
        parser.parseExpression("booleanList[0]").setValue(context, "false");
        Boolean b = simple.booleanList.get(0);
        System.out.println("b = " + b);
    }

    class Simple{
        public List<Boolean> booleanList = new ArrayList<>();
    }
}
