package com.lingnan.pojo;
public class User {
    private int userId; // 用户ID
    private String userName; // 用户名
    private String passWord; // 用户密码
    private int age; // 年龄
    private String gender; // 性别
    private String phone; // 手机号
    private String address; // 地址
    private int userState; // 用户状态， 0表示可用 1表示禁用封号
    private int role; // 用户类别， 0表示管理员，1表示普通用户

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(int userId, String userName, String passWard, int age, String gender, String phone, String address,
                int userState, int role) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWard;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.userState = userState;
        this.role = role;
    }

    public User(String userName, String passWard, int age, String gender, String phone, String address, int userState,
                int role) {
        super();
        this.userName = userName;
        this.passWord = passWard;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.userState = userState;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWard) {
        this.passWord = passWard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", passWard=" + passWord + ", age=" + age
                + ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", userState=" + userState
                + ", role=" + role + "]";
    }

}

