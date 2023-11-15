import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		System.out.println("Daftar User");
		LinkedList<User> users = database.getData();

		for (User user : users) {
			System.out.println(user);
		}

		while(true) {
			System.out.println("\nInsert data");
			System.out.print("Id: ");
			String id = scanner.nextLine();
			System.out.print("Name: ");
			String name = scanner.nextLine();
			System.out.print("Email: ");
			String email = scanner.nextLine();
			System.out.print("Password: ");
			String password = scanner.nextLine();
			User user = new User(id, name, email, password);
			database.addUser(user);
			System.out.print("Continue? (y/n)");
			String answer = scanner.nextLine();
			if (answer.equals("n")) {
				break;
			}
		}

		System.out.println("\nDaftar User setelah insert");
		users = database.getData();
		for (User user : users) {
			System.out.println(user);
		}




	}
}
