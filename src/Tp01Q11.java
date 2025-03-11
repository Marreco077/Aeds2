import java.util.Scanner;

public class Tp01Q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            String words = scanner.nextLine();

            if (words.equals("FIM")) {
                break;
            }

            System.out.println(countSubstring(words));
        }
    }

    public static int countSubstring(String words) {
        StringBuilder substrings = new StringBuilder();
        int count = 0;
        int bigger = 1;

        for (int i = 0; i < words.length(); i++) {
            char currentChar = words.charAt(i);

            if (substrings.indexOf(String.valueOf(currentChar)) != -1) {
                int index = substrings.indexOf(String.valueOf(currentChar));
                substrings.delete(0, index + 1);
                count = substrings.length();
            }

            substrings.append(currentChar);
            count++;

            if (count > bigger) {
                bigger = count;
            }
        }
        return bigger;
    }
}
