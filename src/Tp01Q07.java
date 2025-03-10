import java.util.Scanner;

public class Tp01Q07 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while(true) {
            String word = scanner.nextLine();

            if (word.equals("FIM")) {
                break;
            }

            System.out.println(invertString(word));
        }
    }

    public static StringBuilder invertString(String word) {
        StringBuilder invertString = new StringBuilder();

        for(int i  = word.length() - 1; i >= 0; i--) {
            invertString.append(word.charAt(i));
        }
        return invertString;
    }
}
