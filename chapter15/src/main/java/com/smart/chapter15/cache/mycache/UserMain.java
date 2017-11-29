package com.smart.chapter15.cache.mycache;

/**
 * UserMain
 *
 * @author ascend
 * @date 2017/11/29 22:11
 */
public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();
        // 开始查询账号
        userService.getUserById("001001");
        userService.getUserById("001001");

        // 重置缓存
        userService.reload();
        System.out.println("after reaload...");

        userService.getUserById("001001");
        userService.getUserById("001001");
    }
}
