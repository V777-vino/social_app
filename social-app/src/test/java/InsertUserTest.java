import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Scanner;

import com.kvcet.socialapp.dao.UserDao;
import com.kvcet.socialapp.dao.impl.UserDaoImpl;
import com.kvcet.socialapp.model.User;
import com.kvcet.socialapp.service.UserService;
import com.kvcet.socialapp.service.impl.UserServiceImpl;

public class InsertUserTest {
	public static void main(String[] args) throws Exception {
		insertUser();
	}

	public static void insertUser() throws Exception {
		int a = 0;
		int b = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name:");
		String userName = sc.next();
		System.out.println("Enter the mail:");
		String userEmail = sc.next();
		System.out.println("Enter the mobile no");
		BigInteger mobileNo = sc.nextBigInteger();
		System.out.println("Enter your password");
		String password = sc.next();
		System.out.println("Enter your gender(M/F)");
		char gender = sc.next().charAt(0);
		System.out.println("Enter your dob");
		LocalDate dob = LocalDate.parse(sc.next());

		User user = new User();
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setMobileNo(mobileNo);
		user.setPassword(password);
		user.setGender(gender);
		user.setDob(dob);

		UserService us = new UserServiceImpl();
		UserDao ud = new UserDaoImpl();
		try {
			a= us.registerUserValidation(user);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (a == 1) {
			try {
				b = us.userDetailsCheck(user);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			if (b == 1) {
				ud.insertUser(user);
			}

		}
	}
}
