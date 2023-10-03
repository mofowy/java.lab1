import java.util.Scanner;

class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (validateEmail(email)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static boolean validateEmail(final String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        // Перевірка, чи є "@" та "." в рядку, і чи "@" перед ".".
        if (atIndex <= 0 || dotIndex <= atIndex || dotIndex == email.length() - 1) {
            return false;
        }

        return true;
    }
}