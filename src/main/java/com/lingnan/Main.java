package com.lingnan;
import com.lingnan.service.IUserService;
import com.lingnan.view.CustomerView;


public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "GBK");
        CustomerView cust = new CustomerView();
        cust.consoleMenu();
    }

}