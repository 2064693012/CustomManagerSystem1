package com.lingnan.service.impl;
import com.lingnan.dao.IUserDao;
import com.lingnan.dao.impl.UserDaoImpl;
import com.lingnan.pojo.User;
import com.lingnan.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao= new UserDaoImpl();

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findUserByNameAndPassword(String userName, String password) {
        return userDao.findUserByNameAndPassword(userName, password);
    }

    @Override
    public String findPasswordById(int userId) {
        return userDao.findPasswordById(userId);
    }

    @Override
    public boolean updatePasswordById(int userId, String newPassword) {
        return userDao.updatePasswordById(userId, newPassword);
    }

    @Override
    public List<User> findUser(int role) {
        return userDao.findUser(role);
    }

    @Override
    public User findUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public int getUserIdByName(String userName) {
        return userDao.getUserIdByName(userName);
    }

    @Override
    public boolean updateUserStateById(int userId, int userState) {
        return userDao.updateUserStateById(userId, userState);
    }

    @Override
    public boolean deleteUserByIdAndUsername(int userId, String userName) {
        return userDao.deleteUserByIdAndUsername(userId, userName);
    }

    @Override
    public boolean updateBaseInfo(int userId, int age, String gender, String phone, String address) {
        return userDao.updateBaseInfo(userId, age, gender, phone, address);
    }

}

