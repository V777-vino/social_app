import java.util.Scanner;

import com.kvcet.socialapp.dao.UserDao;
import com.kvcet.socialapp.dao.impl.UserDaoImpl;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		loginTest();

	}

	public static void loginTest() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Email id");
		String email = sc.next();
		System.out.println("Enter a password");
		String password = sc.next();

		UserDao ud = new UserDaoImpl();
		int a = ud.login(email, password);
		if (a == 1) {
			System.out.println("loggedin succesfully");
		} else if (a == -1) {
			System.out.println("Invalid credentials");
		} else if (a == 0) {
			System.out.println("no user found");
		}
	}

}
