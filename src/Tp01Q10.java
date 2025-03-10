import java.util.Scanner;

public class Tp01Q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while(true) {
            String words = scanner.nextLine();

            if (words.equals("FIM")) {
                break;
            }

            System.out.println(countWords(words));
        }
    }

    public static int countWords(String words) {
        int count = 1;

        for(int i = 0; i < words.length(); i++) {
            if(words.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
