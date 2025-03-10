import java.util.Scanner;

public class Tp01Q01 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String word = scanner.nextLine();

            if (word.equals("FIM")) {
                break;
            }

            System.out.println(isPalindrome(word));
        }

        scanner.close();
    }

    public static String isPalindrome(String word) {
        int len = word.length() - 1;
        int count = 0;
        for(int i = len; i > len / 2; i--) {
            if(word.charAt(count) != word.charAt(i)) {
                return "NAO";
            }
            count++;
        }

        return "SIM";
    }
}
