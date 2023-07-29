package com.lingnan.dao;
import com.lingnan.pojo.User;

import java.util.List;

public interface IUserDao {

    boolean addUser(User user);

    User findUserByNameAndPassword(String userName, String password);

    String findPasswordById(int userId);

    boolean updatePasswordById(int userId, String newPassword);

    List<User> findUser(int role);

    User findUserById(int userId);

    int getUserIdByName(String userName);

    boolean updateUserStateById(int userId, int userState);

    boolean deleteUserByIdAndUsername(int userId, String userName);

    boolean updateBaseInfo(int userId, int age, String gender, String phone,String address);

}

