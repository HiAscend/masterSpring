package com.smart.chapter9.spel;

import com.smart.chapter9.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * ObjectExprSample
 *
 * @author ascend
 * @date 2017/11/14 16:39.
 */
public class ObjectExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 赋值

        // 通过setValue赋值
        parser.parseExpression("userName").setValue(context, "jony");
        System.out.println("user.getUserName() = " + user.getUserName());

        // 通过表达式赋值
        parser.parseExpression("userName='anyli'").getValue(context);
        System.out.println("user.getUserName() = " + user.getUserName());

        // 类型

        // 加载java.lang.String
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println("stringClass==java.lang.String = " + (stringClass == String.class));

        // 加载com.smart.chapter9.User
        Class userClass = parser.parseExpression("T(com.smart.chapter9.User)").getValue(Class.class);
        System.out.println("(userClass=User.class) = " + (userClass == User.class));

        // 构造器
        User uu = parser.parseExpression("new com.smart.chapter9.User('katherine')").getValue(User.class);
        System.out.println("uu.getUserName() = " + uu.getUserName());

        // 变量
        // 1、为newUserName变量设置新值
        context.setVariable("newUserName", "damon");
        // 2、取变量值并赋值
        parser.parseExpression("userName=#newUserName").getValue(context);
        System.out.println("user.getUserName() = " + user.getUserName());
        // 3、this变量值使用
        List<Integer> credits = new ArrayList<>();
        credits.addAll(Arrays.asList(150,100,90,50,110,130,70));
        context.setVariable("credits", credits);
        List<Integer> creditsGreater100 = (List<Integer>) parser.parseExpression("#credits.?[#this>100]").getValue(context);
        System.out.println("creditsGreater100 = " + creditsGreater100);

        // 集合过滤
        Map<String, Integer> creditsMap = new HashMap<>();
        creditsMap.put("aTom",95);
        creditsMap.put("bJony",110);
        creditsMap.put("cMorin",85);
        creditsMap.put("dMose",120);
        creditsMap.put("eMorrow",60);
        context.setVariable("credits",creditsMap);
        Map<String, Integer> creditsGreater90 = (Map<String, Integer>) parser.parseExpression("#credits.?[value>90]").getValue(context);
        Object result1 = parser.parseExpression("#credits.^[value>90]").getValue(context);  // 第一个
        Object result2 = parser.parseExpression("#credits.$[value>90]").getValue(context);  // 最后一个
        System.out.println("creditsGreater90 = " + creditsGreater90);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        // 集合转换
        credits = new ArrayList<>();
        credits.addAll(Arrays.asList(150,100,90,50,110,130,70));
        context.setVariable("credits", credits);
        List<Boolean> creditsBoolean = (List<Boolean>) parser.parseExpression("#credits.![#this>100]").getValue(context);
        System.out.println("Arrays.toString(creditsBoolean) = " + creditsBoolean);
    }
}
