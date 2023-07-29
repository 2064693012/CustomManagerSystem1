package com.lingnan.service.impl;

import com.lingnan.dao.CustomerDao;
import com.lingnan.dao.impl.CustomerDaoMysqlImpl;
import com.lingnan.pojo.Customer;
import com.lingnan.service.CustomerService;
import java.util.List;

public class CustomerServiceMysqlImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoMysqlImpl();
    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id, String name) {
        return customerDao.deleteCustomer(id,name);
    }

    @Override
    public List<Customer> findCustomerList() {
        return customerDao.findCustomerList();
    }

    @Override
    public Customer findCustomer(int id, String name) {
        return customerDao.findCustomer(id,name);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public List<Customer> findCustomer(String name) {
        return customerDao.findCustomer(name);
    }

    @Override
    public boolean changeCustomerBaseInfo(int id, String name, String gender, int age, String phone, String email) {
        return customerDao.changeCustomerBaseInfo(id,name,gender,age,phone,email);
    }
}
