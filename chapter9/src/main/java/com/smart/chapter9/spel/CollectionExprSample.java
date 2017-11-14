package com.smart.chapter9.spel;

import com.smart.chapter9.PlaceOfBirth;
import com.smart.chapter9.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * CollectionExprSample
 *
 * @author ascend
 * @date 2017/11/14 15:12.
 */
public class CollectionExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));
        user.setInterestsArray(new String[]{"Java","C++"});
        Map interestsMap = new HashMap(2);
        interestsMap.put("interest1","Java");
        interestsMap.put("interest2","C++");
        user.setInterestsMap(interestsMap);
        List<String> interestsList = new ArrayList<>();
        interestsList.add("Java");
        interestsList.add("C++");
        user.setInterestsList(interestsList);

        //
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 数组表达式解析
        int[] array1 = parser.parseExpression("new int[]{1,2,3}").getValue(context, int[].class);
        System.out.println("Arrays.toString(array1) = " + Arrays.toString(array1));
        int[][] array2 = parser.parseExpression("new int[2][3]").getValue(context, int[][].class);
        System.out.println("Arrays.toString(array2) = " + Arrays.toString(array2));

        // 目前不支持多维数组初始化

        // 2、List表达式解析
        List list = parser.parseExpression("{1,2,3,4}").getValue(context, List.class);
        System.out.println("list = " + list);
        List listOfList = parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context, List.class);
        System.out.println("listOfList = " + listOfList);

        // 3、列表字符串解析
        Map userInfo = parser.parseExpression("{userName:'tom', credits:100}").getValue(context, Map.class);
        System.out.println("userInfo = " + userInfo);
        List userInfo2 = parser.parseExpression("{{userName:'tom',credits:100},{userName:'tom',credits:100}}").getValue(context, List.class);
        System.out.println("userInfo2 = " + userInfo2);

        // 4、从数组，List，Map中取值
        String interest1 = parser.parseExpression("interestsArray[0]").getValue(context, String.class);
        String interest2 = parser.parseExpression("interestsList[0]").getValue(context, String.class);
        String interest3 = parser.parseExpression("interestsMap['interest1']").getValue(context, String.class);
        System.out.println("interest1 = " + interest1);
        System.out.println("interest2 = " + interest2);
        System.out.println("interest3 = " + interest3);
    }
}
