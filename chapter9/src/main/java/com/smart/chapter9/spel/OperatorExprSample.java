package com.smart.chapter9.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.testng.annotations.Test;

/**
 * OperatorExprSample
 *
 * @author ascend
 * @date 2017/11/14 15:48.
 */
public class OperatorExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        // 关系操作符
        boolean trueValue = parser.parseExpression("2==2").getValue(Boolean.class);
        boolean falseValue = parser.parseExpression("2<-5.0").getValue(Boolean.class);
        System.out.println("trueValue = " + trueValue);
        System.out.println("falseValue = " + falseValue);

        // 字符串关系比较
        trueValue = parser.parseExpression("\"black\"<\"block\"").getValue(Boolean.class);
        System.out.println("trueValue = " + trueValue);

        // instanceOf运算符
        falseValue = parser.parseExpression("'xyz' instanceOf T(int)").getValue(Boolean.class);
        System.out.println("falseValue = " + falseValue);

        // 正则
        boolean trueValue2 = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        boolean falseValue3 = parser.parseExpression("'5.0067' matches '\\^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);


    }

    @Test
    public void test() {
        final String[] str = {"hello"};
        new Thread(new Runnable() {
            @Override
            public void run() {
                str[0] = "world";
            }
        });
    }
}
