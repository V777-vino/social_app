import java.util.Scanner;

import com.kvcet.socialapp.dao.UserDao;
import com.kvcet.socialapp.dao.impl.UserDaoImpl;
import com.kvcet.socialapp.service.UserService;
import com.kvcet.socialapp.service.impl.UserServiceImpl;

public class DeleteUserTest {
	public static void main(String[] args) throws Exception {
		deleteUserTest();
	}

	public static void deleteUserTest() throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = 0;

		System.out.println("Enter the user id:");
		int userId = sc.nextInt();

		UserService us = new UserServiceImpl();
		UserDao ud = new UserDaoImpl();

		a = us.userIdCheck(userId);

		if (a == 1) {
			ud.deleteUser(userId);
		}
		if (a == 0) {
			System.err.println("Invalid user id!");
		}

	}

}
