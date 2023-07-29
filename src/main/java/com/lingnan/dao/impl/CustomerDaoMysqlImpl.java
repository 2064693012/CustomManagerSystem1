package com.lingnan.dao.impl;

import com.lingnan.dao.CustomerDao;
import com.lingnan.pojo.Customer;
import com.lingnan.util.JdbcUtil;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDaoMysqlImpl implements CustomerDao {


    @Override
    public boolean addCustomer(Customer customer) {
        String sql="insert into t_customer(name,gender,age,phone,email) values(?,?,?,?,?)";
        return JdbcUtil.executeUpdate(sql,customer.getName(),customer.getGender(),customer.getAge()
        ,customer.getPhone(),customer.getEmail());
    }

    @Override
    public boolean deleteCustomer(int id, String name) {
        String sql = "delete from t_customer where id = ? and name = ?";
        boolean flag = JdbcUtil.executeUpdate(sql,id, name);
        if (flag) {
            System.out.println("成功删除了客户");
        } else {
            System.out.println("删除客户失败");
        }
        return flag;
    }

    @Override
    public List<Customer> findCustomerList() {
        String sql="select *from t_customer";
        List<Customer> listcustomer=new ArrayList<>();
        List<Map<String,Object>>list=JdbcUtil.executeQuery(sql);
        for (Map<String, Object> map : list) {
            Customer customer= new Customer((int) map.get("id"), (String) map.get("name"),
                    (String) map.get("gender"), (int) map.get("age"), (String) map.get("phone"),
                    (String) map.get("email"));
            listcustomer.add(customer);
        }
        return listcustomer;
    }


    @Override
    public Customer findCustomer(int id,String name) {
        String sql = "select * from t_customer where id = ? and name = ?";
        Customer customer = null;

        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, id, name);

        for (Map<String, Object> map : list) {
            customer =  new Customer((int) map.get("id"), (String) map.get("name"),
                    (String) map.get("gender"), (int) map.get("age"), (String) map.get("phone"),
                    (String) map.get("email"));
        }
        return customer;
    }

    @Override
    public Customer findCustomerById(int id) {
        String sql = "select * from t_customer where id = ?";
        Customer customer = null;

        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql, id);

        for (Map<String, Object> map : list) {
            customer =  new Customer((int) map.get("id"), (String) map.get("name"),
                    (String) map.get("gender"), (int) map.get("age"), (String) map.get("phone"),
                    (String) map.get("email"));
        }
        return customer;
    }


    @Override
    public List<Customer> findCustomer(String name) {
        String sql="select * from t_customer where name like ? or email like ?";
        List<Customer> listcustomer=new ArrayList<>();
        List<Map<String, Object>> list = JdbcUtil.executeQuery(sql,"%"+name+"%","%"+name+"%");
        for (Map<String, Object> map : list) {
            Customer customer= new Customer((int) map.get("id"), (String) map.get("name"),
                    (String) map.get("gender"), (int) map.get("age"), (String) map.get("phone"),
                    (String) map.get("email"));
            listcustomer.add(customer);
        }
        return listcustomer;
    }

    @Override
    public boolean changeCustomerBaseInfo(int id, String name, String gender, int age, String phone, String email) {
        String sql = "update t_customer set name = ?, gender = ?, age = ?, phone= ?, email= ? where id = ?";

        Customer customer = findCustomer(id, name);

        if (name.equals("")) {
            name = customer.getName();
        }

        if (gender.equals("")) {
            gender= customer.getGender();
        }

        if (age== -1) {
            age= customer.getAge();
        }

        if (phone.equals("")) {
            phone = customer.getPhone();
        }

        if (email.equals("")) {
           email=customer.getEmail();
        }

        boolean flag = JdbcUtil.executeUpdate(sql,name,gender,age,phone,email,id);

        if (flag) {
            System.out.println("成功修改了客户基本信息");
        } else {
            System.out.println("修改客户基本信息失败");
        }
        return flag;
    }

}