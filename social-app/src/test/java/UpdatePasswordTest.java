import java.util.Scanner;

import com.kvcet.socialapp.dao.UserDao;
import com.kvcet.socialapp.dao.impl.UserDaoImpl;
import com.kvcet.socialapp.service.UserService;
import com.kvcet.socialapp.service.impl.UserServiceImpl;

public class UpdatePasswordTest {

	public static void main(String[] args) throws Exception {
		updatePasswordTest();
	}
	public static void updatePasswordTest() throws Exception {
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id:");
		int userId = sc.nextInt();
		System.out.println("Enter your new password");
		String password = sc.next();

		UserService us = new UserServiceImpl();
		UserDao ud = new UserDaoImpl();

		a = us.updatePassword(password, userId);

		if (a == 1) {
			ud.updatePassword(password, userId);
		}
		if (a == 0) {
			System.err.println("No user found");
		}

	}

}
