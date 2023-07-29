package com.lingnan.dao;

import com.lingnan.pojo.Customer;

import java.util.List;

public interface CustomerDao {
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(int id,String name);
    List<Customer>findCustomerList();
    Customer findCustomer(int id,String name);
    Customer findCustomerById(int id);
    List<Customer> findCustomer(String name);
    boolean changeCustomerBaseInfo(int id,String name,String gender,int age,String phone,String email);
}
