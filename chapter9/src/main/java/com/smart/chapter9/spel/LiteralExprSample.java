package com.smart.chapter9.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * LiteralExprSample
 *
 * @author ascend
 * @date 2017/11/14 14:56.
 */
public class LiteralExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        // 1、解析字符串
        String helloWorld = parser.parseExpression("\"Hello World\"").getValue(String.class);
        System.out.println("helloWorld = " + helloWorld);
        // 2、解析双精度浮点数
        double doubleNumber = parser.parseExpression("6.0221215E+23").getValue(Double.class);

    }
}
