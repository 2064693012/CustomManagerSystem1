package com.lingnan.service;

import com.lingnan.pojo.Customer;

import java.util.List;
import java.util.Vector;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(int id,String name);
    List<Customer>findCustomerList();
    Customer findCustomer(int id,String name);
    Customer findCustomerById(int id);
    List<Customer> findCustomer(String name);
    boolean changeCustomerBaseInfo(int id,String name,String gender,int age,String phone,String email);
}