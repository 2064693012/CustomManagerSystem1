package com.lingnan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.lingnan.dao.IUserDao;
import com.lingnan.pojo.User;
import com.lingnan.util.JdbcUtil;

public class UserDaoImpl implements IUserDao {

    /**
     * 用户添加
     */
    @Override
    public boolean addUser(User user) {
        String sql = "insert into t_user (user_name,password,age,gender,phone,address,user_state,role) values(?,?,?,?,?,?,?,?)";
        boolean flag = JdbcUtil.executeUpdate(sql, user.getUserName(), user.getPassWord(), user.getAge(),
                user.getGender(), user.getPhone(), user.getAddress(), user.getUserState(), user.getRole());
        user.setUserId(getUserIdByName(user.getUserName()));
        return flag;
    }

    @Override
    public User findUserByNameAndPassword(String userName, String password) {
        String sql = "select * from t_user where user_name = ? and password = ?";
        User user = null;
        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, userName, password);

        for (Map<String, Object> map : list) {
            user = new User((int) map.get("user_id"), (String) map.get("user_name"), (String) map.get("password"),
                    (int) map.get("age"), (String) map.get("gender"), (String) map.get("phone"),
                    (String) map.get("address"), (int) map.get("user_state"), (int) map.get("role"));
        }
        return user;
    }

    @Override
    public String findPasswordById(int userId) {
        String sql = "select * from t_user where user_id = ?";
        String password = null;
        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, userId);

        for (Map<String, Object> map : list) {
            password = (String) map.get("password");
        }

        return password;
    }

    @Override
    public boolean updatePasswordById(int userId, String newPassword) {
        String sql = "update t_user set password = ? where user_id = ?";
        boolean flag = JdbcUtil.executeUpdate(sql, newPassword, userId);

        if (flag) {
            System.out.println("成功修改了密码");
        } else {
            System.out.println("修改密码失败");
        }
        return flag;
    }

    @Override
    public User findUserById(int userId) {
        String sql = "select * from t_user where user_id = ?";
        User user = null;

        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, userId);

        for (Map<String, Object> map : list) {
            user = new User((int) map.get("user_id"), (String) map.get("user_name"), (String) map.get("password"),
                    (int) map.get("age"), (String) map.get("gender"), (String) map.get("phone"),
                    (String) map.get("address"), (int) map.get("user_state"), (int) map.get("role"));
        }
        return user;
    }

    @Override
    public boolean updateUserStateById(int userId, int userState) {
        String sql = "update t_user set user_state = ? where user_id = ?";
        boolean flag = JdbcUtil.executeUpdate(sql, userState, userId);

        if (flag) {
            System.out.println("成功修改了用户状态");
        } else {
            System.out.println("修改用户状态失败");
        }
        return flag;
    }

    @Override
    public boolean deleteUserByIdAndUsername(int userId, String userName) {
        String sql = "delete from t_user where user_id = ? and user_name = ?";
        boolean flag = JdbcUtil.executeUpdate(sql, userId, userName);
        if (flag) {
            System.out.println("成功删除了用户");
        } else {
            System.out.println("删除用户失败");
        }
        return flag;
    }

    @Override
    public List<User> findUser(int role) {
        String sql = "select * from t_user where role = ?";
        List<User> listUser = new ArrayList<>();

        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, role);
        for (Map<String, Object> map : list) {
            User user = new User((int) map.get("user_id"), (String) map.get("user_name"), (String) map.get("password"),
                    (int) map.get("age"), (String) map.get("gender"), (String) map.get("phone"),
                    (String) map.get("address"), (int) map.get("user_state"), (int) map.get("role"));
            listUser.add(user);
        }
        return listUser;
    }

    @Override
    public int getUserIdByName(String userName) {
        String sql = "select * from t_user where user_name = ?";
        int id = -1;
        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, userName);

        for (Map<String, Object> map : list) {
            id = (int) map.get("user_id");
        }

        return id;
    }

    @Override
    public boolean updateBaseInfo(int userId, int age, String gender, String phone, String address) {
        String sql = "update t_user set age = ?, gender = ?, phone = ?, address = ? where user_id = ?";
        User user = findUserById(userId);

        if (age == -1) {
            age = user.getAge();
        }

        if (gender.equals("")) {
            gender = user.getGender();
        }

        if (phone.equals("")) {
            phone = user.getPhone();
        }

        if (address.equals("")) {
            address = user.getAddress();
        }

        boolean flag = JdbcUtil.executeUpdate(sql, age, gender, phone, address, userId);

        if (flag) {
            System.out.println("修改信息成功");
        } else {
            System.out.println("修改信息失败");
        }

        return flag;
    }

}

