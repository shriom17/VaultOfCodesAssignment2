import java.util.Scanner;

public class SimpleTextEncoder {

    // Method to encode text
    public static String encode(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                result += (char) ((c - 'A' + shift) % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                result += (char) ((c - 'a' + shift) % 26 + 'a');
            } else {
                result += c; // Keep non-letters unchanged
            }
        }
        return result;
    }

    // Method to decode text
    public static String decode(String text, int shift) {
        return encode(text, 26 - (shift % 26)); // Reverse shift
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Encode a message");
            System.out.println("2. Decode a message");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter your message: ");
            String message = sc.nextLine();
            System.out.print("Enter shift number: ");
            int shift = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("Encoded message: " + encode(message, shift));
            } else if (choice == 2) {
                System.out.println("Decoded message: " + decode(message, shift));
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
