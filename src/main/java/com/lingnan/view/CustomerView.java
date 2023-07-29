package com.lingnan.view;

import com.lingnan.controller.CustomerController;
import com.lingnan.controller.UserController;

import com.lingnan.pojo.Customer;
import com.lingnan.pojo.User;
import com.lingnan.util.CMUtility;

import java.util.List;

public class CustomerView {
    CustomerController customerController = new CustomerController();
    UserController userController = new UserController();
    User user;

    public void consoleMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("==========客户管理控制台菜单=======");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 退出");
            System.out.println("===============================");

            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    flag = false;
                    System.out.println("退出成功！");
                    break;
                default:
                    System.out.println("无效的选择，请重新选择！");
                    break;
            }
        }
    }

    private void login() {
        int attempts = 0; // 登录尝试次数计数器
        boolean loggedIn = false; // 是否已成功登录的标志

        while (attempts < 3 && !loggedIn) {
            System.out.println("========== 登录 ==========");
            System.out.print("用户名：");
            String userName = CMUtility.readString(16);
            System.out.print("密码：");
            String password = CMUtility.readString(16);

            user = UserController.login(userName, password);
            if (user != null) {
                System.out.println("登录成功！");
                // 根据用户角色进行相应操作
                if (user.getRole() == 0) {
                    // 管理员菜单
                    AdminMainMenu();
                } else if (user.getRole() == 1) {
                    // 普通用户菜单
                    CustomerMainMenu();
                }
                loggedIn = true; // 登录成功1
            } else {
                attempts++; // 登录失败，尝试次数加一
                int remainingAttempts = 3 - attempts;
                if (remainingAttempts > 0) {
                    System.out.println("登录失败！用户名或密码错误！还有" + remainingAttempts + "次尝试机会。");
                } else {
                    System.out.println("登录失败！用户名或密码错误！已达到最大尝试次数。");
                }
            }
        }
    }


    private void register() {
        System.out.println("========== 注册 ==========");
        System.out.print("用户名：");
        String userName = CMUtility.readString(16);
        System.out.print("密码：");
        String passWord1 = CMUtility.readString(16);
        System.out.print("重复密码：");
        String passWord2 = CMUtility.readString(16);
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("性别：");
        String gender = CMUtility.readString(16);
        System.out.print("电话：");
        String phone = CMUtility.readString(16);
        System.out.print("地址：");
        String address = CMUtility.readString(16);
        System.out.println("用户类别：0表示管理员，1表示普通用户");
        System.out.print("用户类别：");
        int role = CMUtility.readInt();

        System.out.print("用户名：" + userName);
        System.out.print("密码：" + passWord1);
        System.out.print("重复密码：" + passWord2);
        System.out.print("年龄：" + age);
        System.out.print("性别：" + gender);
        System.out.print("电话：" + phone);
        System.out.print("地址：" + address);
        System.out.print("用户类别：0表示管理员，1表示普通用户：" + role);

        if (userName.equals("") || passWord1.equals("") || passWord2.equals("") || phone.equals("") || address.equals("")) {
            System.out.println("输入数据中有空数据，非法，请重新输入！");
            System.out.println("输入数据中有空数据，非法，请重新输入！");
        } else if (!passWord1.equals(passWord2)) {
            System.out.println("两次输入的密码不一致，请重新输入！");
            System.out.println("两次输入的密码不一致，请重新输入！");
        } else {
            User user = new User(userName, passWord1, age, gender, phone, address, 0, role);
            boolean flag = UserController.register(user);
            System.out.println(flag);
            if (flag) {
                System.out.println("恭喜您注册成功！");
            } else {
                System.out.println("注册失败！");
            }
        }
    }

    public void AdminMainMenu() {
        // 管理员菜单逻辑
        // TODO: 添加管理员菜单功能
        System.out.println("管理员菜单");
        boolean exit = false;
        while (!exit) {
            System.out.println("========== 客户信息管理系统 ==========");
            System.out.println("1. 添加客户");
            System.out.println("2. 修改客户");
            System.out.println("3. 删除客户");
            System.out.println("4. 查询客户");
            System.out.println("5. 禁用与启用用户");
            System.out.println("6. 查询用户列表");
            System.out.println("7. 添加用户");
            System.out.println("8. 管理个人信息");
            System.out.println("9. 退出");
            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();
            switch (choice) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    modifyCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    findCustomer();
                    break;
                case 5:
                    ChangeUserState(user); // 禁用与启用用户
                    break;
                case 6:
                    SearchUserList();
                    break;
                case 7:
                    AddAdmin();
                    break;
                case 8:
                    userInfoSearch(user);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    public void CustomerMainMenu() {
        // 普通用户菜单逻辑
        // TODO: 添加普通用户菜单功能
        System.out.println("普通用户菜单");
        boolean exit2 = false;
        while (!exit2) {
            System.out.println("========== 客户信息管理系统 ==========");
            System.out.println("1. 管理个人信息");
            System.out.println("2. 查询客户");
            System.out.println("3. 退出");
            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();
            switch (choice) {
                case 1:
                    userInfoSearch(user);
                    break;
                case 2:
                    findCustomer();
                    break;
                case 3:
                    exit2 = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    private void addNewCustomer() {
        // 添加客户逻辑
        System.out.println("------------添加客户------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(16);
        System.out.print("性别：");
        String gender = CMUtility.readString(16);
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(16);
        System.out.print("邮箱：");
        String email = CMUtility.readString(16);

        Customer customer = new Customer(name, gender, age, phone, email);

        if (customerController.addCustomer(customer)) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败，客户列表已满！");
        }
    }

    private void modifyCustomer() {
        listAllCustomers();
        System.out.println("------------修改客户------------");
        System.out.print("编号：");
        int id = CMUtility.readInt();
        Customer customer = customerController.findCustomerById(id);
        System.out.println(customer);
        if (customer != null ) {
            // Customer found, prompt for new data
            System.out.print("新姓名：");
            String newName = CMUtility.readString(16);
            System.out.print("新性别：");
            String newGender = CMUtility.readString(16);
            System.out.print("新年龄：");
            int newAge = CMUtility.readInt();
            System.out.print("新电话：");
            String newPhone = CMUtility.readString(16);
            System.out.print("新邮箱：");
            String newEmail = CMUtility.readString(16);
            if (customerController.changeCustomerBaseInfo(id, newName, newGender, newAge, newPhone, newEmail)) {
                System.out.println("客户修改成功！");
                System.out.println("编号:" + id + "  姓名:" + newName + "  性别:" + newGender + "  年龄:" + newAge + newPhone + "  邮箱/地址:" + newEmail);
            } else {
                System.out.println("客户修改失败！");
            }
        } else {
            System.out.println("客户不存在！");
        }
    }

    private void deleteCustomer() {
        // 删除客户逻辑
        listAllCustomers();
        System.out.println("------------删除客户------------");
        System.out.print("编号：");
        int id = CMUtility.readInt();
        System.out.print("姓名：");
        String name = CMUtility.readString(16);
        if (customerController.deleteCustomer(id, name)) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    private void listAllCustomers() {
        // 获取并展示客户列表逻辑
        System.out.println("-------------------------------------客户列表--------------------------------------------------");
        System.out.println("编号\t\t\t\t姓名\t\t\t\t性别\t\t\t年龄\t\t\t电话\t\t\t\t邮箱/地址");
        List<Customer> listcustomer = customerController.findCutomerList();
        for (Customer i : listcustomer) {
            System.out.println(i);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");

    }

    public void userInfoSearch(User user) {
        boolean exit_2 = false;
        while (!exit_2) {
            System.out.println("========== 客户信息管理系统 ==========");
            System.out.println("1. 查看个人信息");
            System.out.println("2. 修改密码");
            System.out.println("3. 修改个人信息");
            System.out.println("4. 退出");
            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();
            switch (choice) {
                case 1:
                    User updatedUser = userController.findUserById(user.getUserId()); // Fetch the updated user information from the database
                    if (updatedUser != null) {
                        System.out.println("========== 用户信息 ==========");
                        System.out.printf("%-10s: %s%n", "用户ID", updatedUser.getUserId());
                        System.out.printf("%-10s: %s%n", "用户名", updatedUser.getUserName());
                        System.out.printf("%-10s: %s%n", "用户密码", updatedUser.getPassWord());
                        System.out.printf("%-10s: %s%n", "年龄", updatedUser.getAge());
                        System.out.printf("%-10s: %s%n", "性别", updatedUser.getGender());
                        System.out.printf("%-10s: %s%n", "电话", updatedUser.getPhone());
                        System.out.printf("%-10s: %s%n", "地址", updatedUser.getAddress());
                        System.out.printf("%-10s: %s%n", "用户状态", updatedUser.getUserState() == 0 ? "正常" : "禁用");
                        System.out.printf("%-10s: %s%n", "用户类别", updatedUser.getRole() == 0 ? "管理员" : "普通用户");
                        System.out.println("==============================");
                    } else {
                        System.out.println("未能获取更新后的用户信息，请重试！");
                    }
                    break;
                case 2:
                    UpdataPasswordPage(user);
                    break;
                case 3:
                    UpdateBaseInfoPage(user);
                    break;
                case 4:
                    exit_2 = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }


    public void UpdataPasswordPage(User user) {
        System.out.print("旧密码：");
        String oldPassword = CMUtility.readString(16);
        System.out.print("新密码：");
        String newPassword1 = CMUtility.readString(16);
        System.out.print("确认密码：");
        String newPassword2 = CMUtility.readString(16);
        if (!oldPassword.equals(user.getPassWord())) {
            System.out.println("旧密码错误！");
        } else {
            if (!newPassword1.equals(newPassword2)) {
                System.out.println("两次输入的密码不一样！");
            } else {
                boolean flag = UserController.changePassword(user.getUserId(), newPassword1);
                if (flag) {
                    System.out.println("修改密码成功！");
                    userInfoSearch(user); // 刷新显示个人信息
                } else {
                    System.out.println("修改密码失败！");
                }
            }
        }
    }

    public void UpdateBaseInfoPage(User user) {
        System.out.print("年龄：");
        String ageString = CMUtility.readString(16);
        System.out.print("性别：");
        String gender = CMUtility.readString(16);
        System.out.print("电话：");
        String phone = CMUtility.readString(16);
        System.out.print("地址：");
        String address = CMUtility.readString(16);

        int age;
        if (ageString == null || ageString.equals("")) {
            age = -1;
        } else {
            age = Integer.parseInt(ageString);
        }

        boolean flag = UserController.changeBaseInfo(user.getUserId(), age, gender, phone, address);

        if (flag) {
            System.out.println("更新成功！");
            userInfoSearch(user); // 刷新显示个人信息
        } else {
            System.out.println("更新失败！");
        }
    }

    public void SearchUserList() {
        System.out.println("管理员菜单");
        boolean exit3 = false;
        while (!exit3) {
            System.out.println("========== 客户信息管理系统 ==========");
            System.out.println("1. 管理员列表");
            System.out.println("2. 普通用户列表");
            System.out.println("3. 退出");
            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();
            switch (choice) {
                case 1:
                    List<User> list1 = UserController.findCommonUser(0);
                    for (User us : list1)
                    System.out.println(us);
                    break;
                case 2:
                    List<User> list2 = UserController.findCommonUser(1);
                    for (User us : list2)
                        System.out.println(us);
                    break;
                case 3:
                    exit3 = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    public void AddAdmin() {
        System.out.print("用户名：");
        String userName = CMUtility.readString(16);
        System.out.print("密码：");
        String password = CMUtility.readString(16);
        System.out.println("用户类型：0表示管理员，1表示普通用户");
        System.out.print("用户类型：");
        int role = CMUtility.readInt();

        if (userName.equals("") || userName == null || password.equals("") || password == null) {
            System.out.println("数据未填写完整，请重新输入！");
        } else {
            User us = new User(userName, password, -1, "未知", "未知", "未知", 0, role);
            boolean flag = UserController.register(us);
            if (flag) {
                System.out.println("添加用户成功");
                System.out.println("  用户名：" + userName + "  密码：" + password);
            } else {
                System.out.println("添加用户失败");
            }
        }
    }

    public void ChangeUserState(User user) {
        System.out.println("管理员菜单");
        boolean exit4 = false;
        while (!exit4) {
            List<User> list2 = UserController.findCommonUser(1);
            for (User us : list2)
                System.out.println(us);
            System.out.println("========== 客户信息管理系统 ==========");
            System.out.println("1. 禁用用户账号");
            System.out.println("2. 启用用户账号");
            System.out.println("3. 退出");
            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();
            switch (choice) {
                case 1:
                    System.out.println("禁用用户账号");
                    System.out.print("用户ID：");
                    String userIdS = CMUtility.readString(16);
                    System.out.print("用户名：");
                    String userName = CMUtility.readString(16);

                    if (userIdS.equals("") || userIdS == null || userName.equals("") || userName == null) {
                        System.out.println("未完全填写数据，请重新输入！");
                    } else {
                        int userId = Integer.parseInt(userIdS);
                        boolean flag = UserController.changeUserState(userId, 1);
                        if (flag) {
                            System.out.println("禁用账号成功！");
                        } else {
                            System.out.println("禁用账号失败！");
                        }
                    }
                    break;
                case 2:
                    System.out.println("启用用户账号");
                    System.out.print("用户ID：");
                    String userIdS2 = CMUtility.readString(16);
                    System.out.print("用户名：");
                    String userName2 = CMUtility.readString(16);

                    if (userIdS2.equals("") || userIdS2 == null || userName2.equals("") || userName2 == null) {
                        System.out.println("未完全填写数据，请重新输入！");
                    } else {
                        int userId = Integer.parseInt(userIdS2);
                        boolean flag = UserController.changeUserState(userId, 0);
                        if (flag) {
                            System.out.println("启用账号成功！");
                        } else {
                            System.out.println("启用账号失败！");
                        }
                    }
                    break;
                case 3:
                    exit4 = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }

    }

    public void findCustomer() {
        boolean exit5 = false;
        while (!exit5) {
            System.out.println("========== 客户信息管理系统 ==========");
            System.out.println("1. 精确查找(客户id  和 客户姓名)");
            System.out.println("2. 模糊查找(客户地址 或 客户姓名)");
            System.out.println("3. 客户列表(全部客户)");
            System.out.println("4. 退出");
            System.out.print("请选择操作：");
            int choice = CMUtility.readInt();
            switch (choice) {
                case 1:
                    System.out.print("客户编号：");
                    String CustomerIdString = CMUtility.readString(16);
                    System.out.print("客户姓名：");
                    String CustomerNameString = CMUtility.readString(16);
                    if (CustomerIdString.equals("") || CustomerIdString == null || CustomerNameString.equals("") || CustomerNameString == null) {
                        System.out.println("查询内容未填写完整！");
                    } else {
                        int CustomerId = Integer.parseInt(CustomerIdString);
                        String CustomerName = CustomerNameString;

                        Customer bo = CustomerController.findCustomer(CustomerId, CustomerName);
                        if (bo != null) {
                            System.out.println(bo);
                        } else {
                            System.out.println("没有此客户！");
                        }
                    }
                    break;
                case 2:
                    System.out.print("客户姓名/客户地址：");
                    String CustomerIdString2= CMUtility.readString(16);
                    if (CustomerIdString2.equals("") || CustomerIdString2== null ) {
                        System.out.println("查询内容未填写完整！");
                    } else {
                        List<Customer> listcustomer=CustomerController.findCustomer(CustomerIdString2);
                        if ( listcustomer!= null) {
                            for (Customer i:listcustomer) {
                                System.out.println(i);
                            }
                        } else {
                            System.out.println("没有此客户！");
                        }
                    }
                    break;
                case 3:
                    listAllCustomers();
                    break;
                case 4:
                    exit5= true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }

    }
}
