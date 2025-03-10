import java.util.Scanner;

public class Tp01Q03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while(true) {

            String text = scanner.nextLine();

            if(text.equals("FIM")){
                break;
            }
            System.out.println(CaesarCipher(text));
        }
    }

    public static StringBuilder CaesarCipher(String word) {
        StringBuilder caesar_word = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char newLetter = (char) (word.charAt(i) + 3);

            caesar_word.append(newLetter);
        }
        return caesar_word;
    }
}
