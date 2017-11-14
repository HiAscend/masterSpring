package com.smart.chapter9.spel;

import com.smart.chapter9.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * MethodExprSample
 *
 * @author ascend
 * @date 2017/11/14 15:33.
 */
public class MethodExprSample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 1、调用String方法
        String substring = parser.parseExpression("'Spring SpEL'.substring(7)").getValue(String.class);
        Integer index = parser.parseExpression("'Spring SpEL'.indexOf('SpEL')").getValue(Integer.class);
        System.out.println("substring = " + substring);
        System.out.println("index = " + index);

        // 2、调用实例方法
        boolean isCorrect = parser.parseExpression("validatePassword('123456')").getValue(context, Boolean.class);
        System.out.println("isCorrect = " + isCorrect);

        // 3、调用私有方法将发生错误
//        isCorrect = parser.parseExpression("validatePassword2('123456')").getValue(context, Boolean.class);
        // 4、调用静态方法
        isCorrect = parser.parseExpression("validatePassword3('123456')").getValue(context, Boolean.class);
        System.out.println("isCorrect = " + isCorrect);

        // 5、调用对象方法，可变参数列表
        Boolean value = parser.parseExpression("addInterests('JS','C')").getValue(context, Boolean.class);
        System.out.println("value = " + value);


    }
}
