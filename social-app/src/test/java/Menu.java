
import java.util.Scanner;

public class Menu {
	public static void menu() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n1. Post a message");
		System.out.println("2. Update password");
		System.out.println("3. View all  post");
		System.out.println("4. Delete user");
		System.out.println("5. Exit\n");

		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		if (choice == 1) {
			PostMessageTest.postMessage();
			System.out.println("Returns you main page");
			Menu.menu();
		} else if (choice == 2) {
			UpdatePasswordTest.updatePasswordTest();
			System.out.println("Returns you main page");
			Menu.menu();
		} else if (choice == 3) {
			ViewAllPostTest.viewAllPost();
			System.out.println("Returns you main page");
			Menu.menu();
		} else if (choice == 4) {
			DeleteUserTest.deleteUserTest();
			System.out.println("Returns you main page");
			Menu.menu();

		} else if (choice == 5) {
			System.out.println("Thanks for using social app");
			System.exit(1);
		} else {
			System.out.println("\nWrong input");
			Menu.menu();
		}

	}

}
