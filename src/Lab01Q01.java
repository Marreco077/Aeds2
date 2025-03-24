import java.util.Scanner;

public class Lab01Q01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        String word = scanner.nextLine();

        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                continue;
            }
            else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
            }
        }
        System.out.println(count);
    }
}
