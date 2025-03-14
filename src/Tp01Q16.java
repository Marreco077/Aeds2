import java.util.Scanner;

public class Tp01Q16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            String word = scanner.nextLine();

            if (word.equals("FIM")) {
                break;
            }
            int last_index = word.length() - 1;
            System.out.println(isPalindrome(word, 0, last_index));
        }
    }

    public static String isPalindrome(String word, int index, int last_index) {
        if (index >= last_index) {
            return "SIM";
        }

        if (word.charAt(index) != word.charAt(last_index)) {
            return "NAO";
        }
        index++;
        last_index--;

        return isPalindrome(word, index, last_index);
    }
}
