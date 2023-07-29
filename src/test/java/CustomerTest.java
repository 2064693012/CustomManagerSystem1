import com.lingnan.dao.impl.CustomerDaoMysqlImpl;
import com.lingnan.pojo.Customer;

import java.util.List;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer=new Customer(3,"一书一世界","男",19,"13431","123@qq.com");
        CustomerDaoMysqlImpl b = new CustomerDaoMysqlImpl();
        System.out.println(b.addCustomer(customer));
        List<Customer> listBook = b.findCustomerList();
        for(Customer bo: listBook) {
            System.out.println(bo);
        }
        System.out.println(b.deleteCustomer(3, "一书一世界"));

        System.out.println(b.changeCustomerBaseInfo(1,"一书一世界","男",19,"13431","123@qq.com"));
    }
}
