package com.lingnan.controller;

import com.lingnan.pojo.User;
import com.lingnan.service.IUserService;
import com.lingnan.service.impl.UserServiceImpl;
import java.util.List;

public class UserController {

    private static IUserService uService = new UserServiceImpl();

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public static User login(String userName, String password) {
        return uService.findUserByNameAndPassword(userName, password);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public static boolean register(User user) {
        return uService.addUser(user);
    }

    /**
     * 禁用普通账号与开启
     * @param userId
     * @param userState
     * @return
     */
    public static boolean changeUserState(int userId, int userState) {
        return uService.updateUserStateById(userId, userState);
    }

    /**
     * 查询普通用户列表
     * @return
     */
    public static List<User> findCommonUser(int role){
        return uService.findUser(role);
    }

    /**
     * 查询用户基本信息
     * @param id
     * @return
     */
    public static String findUserInfo(int id) {
        return uService.findUserById(id).toString();
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    public static User findUser(int id) {
        return uService.findUserById(id);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @return
     */
    public static boolean changePassword(int userId, String newPassword) {
        return uService.updatePasswordById(userId, newPassword);
    }

    /**
     * 修改基本信息
     * @param userId
     * @param age
     * @param gender
     * @param phone
     * @param address
     * @return
     */
    public static boolean changeBaseInfo(int userId, int age, String gender, String phone, String address) {
        return uService.updateBaseInfo(userId, age, gender, phone, address);
    }


    public User findUserById(int userId) {
        return uService.findUserById(userId);
    }
}

