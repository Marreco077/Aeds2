import java.util.Random;
import java.util.Scanner;

public class Tp01Q04 {
    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while(true) {
            String words = scanner.nextLine();

            if (words.equals("FIM")) {
                break;
            }

            char letter1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letter2 = (char) ('a' + (Math.abs(gerador.nextInt() % 26)));

            String wordReplace = words.replace(letter1, letter2);

            System.out.println(wordReplace);
        }
    }
}
