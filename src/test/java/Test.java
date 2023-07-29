import com.lingnan.dao.impl.CustomerDaoMysqlImpl;
import com.lingnan.dao.impl.UserDaoImpl;
import com.lingnan.pojo.Customer;
import com.lingnan.pojo.User;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		User user = new User("小王","121212",18,"man","110","sky",0,1);
		UserDaoImpl u = new UserDaoImpl();
		u.addUser(user);
		System.out.println(user.getUserId());

		User user2 = u.findUserByNameAndPassword("张三", "123456");
		System.out.println(user2);

		System.out.println(u.findPasswordById(3));

		System.out.println(u.updatePasswordById(1, "555555"));

		User user3 = u.findUserById(2);
		System.out.println(user3);

		System.out.println(u.updateUserStateById(2, 1));

		System.out.println(u.deleteUserByIdAndUsername(1, "张三"));

		List<User> l = u.findUser(1);
		for(User use: l) {
			System.out.println(use);
		}

		System.out.println(u.getUserIdByName("张三"));

		Customer customer=new Customer(3,"一书一世界","男",19,"13238231","123@qq.com");
		CustomerDaoMysqlImpl b = new CustomerDaoMysqlImpl();
		b.addCustomer(customer);
		b.deleteCustomer(3, "一书一世界");
		List<Customer> listBook = b.findCustomerList();
		for(Customer bo: listBook) {
			System.out.println(bo);
		}

		Customer book2 = b.findCustomer(1, "星子");
		System.out.println(book2);
		b.changeCustomerBaseInfo(2, "xiao星子", "女",29,"13019","12wer@qq.com");
		b.deleteCustomer(1, "星子");
//		new WelcomePage();
	}
}
