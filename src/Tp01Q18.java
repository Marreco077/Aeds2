import java.util.Scanner;

public class Tp01Q18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            String word = scanner.nextLine();

            if(word.equals("FIM")) {
                break;
            }

            System.out.println(caesarCipher(word, 0));
        }
    }

    public static String caesarCipher(String word, int index) {
        if (index >= word.length()) {
            return "";
        }

        char currentChar = word.charAt(index);
        String newChar = "";

        if (currentChar <= 122) {
            newChar = String.valueOf((char) (currentChar+3));
        }
        else {
            newChar = String.valueOf(currentChar);
        }

        return newChar + caesarCipher(word, index+1);
    }
}
