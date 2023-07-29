package com.lingnan.controller;

import com.lingnan.pojo.Customer;
import com.lingnan.service.CustomerService;
import com.lingnan.service.impl.CustomerServiceMysqlImpl;

import java.util.List;

public class CustomerController {
    private static CustomerService customerService=new CustomerServiceMysqlImpl();
    /**
     * 添加客户
     *
     * @param customer
     * @return
     */
    public static boolean addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }
    
    /**
     * 删除客户
     *
     * @param id
     * @param name
     * @return
     */
    public static boolean deleteCustomer(int id, String name) {
    return customerService.deleteCustomer(id, name);
    }

    /**
     * 客户基本信息修改
     *
     * @param id
     * @param name
     * @param gender
     * @param age
     * @param phone
     * @param email
     * @return
     */
    public  boolean changeCustomerBaseInfo(int id,String name,String gender,int age,String phone,String email){
        return customerService.changeCustomerBaseInfo(id, name, gender, age, phone, email);
    }

    /**
     * 客户列表查询
     *
     * @return
     */
    public static List<Customer> findCutomerList() {
        return customerService.findCustomerList();
    }
    /**
     * 客户查询
     *
     * @return
     */
    public static Customer findCustomer(int id,String name){
        return customerService.findCustomer(id,name);
    }
    public static Customer findCustomerById(int id){
        return customerService.findCustomerById(id);
    }
    public static List <Customer>  findCustomer(String name){
        return customerService.findCustomer(name);
    }

}
