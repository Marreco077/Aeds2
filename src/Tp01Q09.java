import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Tp01Q09 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            String word = scanner.nextLine();

            if(word.equals("FIM")) {
                break;
            }
            word = word.replace(" ", "");
            String[] words = word.split("-");
            String word1 = words[0];
            String word2 = words[1];
            System.out.println(isAnagram(word1, word2));

        }
    }

    public static String isAnagram(String word1, String word2) {
        String nao = new String(new byte[]{0x4E, (byte) 0xC3, (byte) 0x83,  0x4F}, StandardCharsets.UTF_8);
        if(word1.length() != word2.length()) {
            return nao;
        }

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            int count1 = 0, count2 = 0;

            for (int j = 0; j < word1.length(); j++) {
                if (word1.charAt(j) == c) {
                    count1++;
                }
            }

            for (int j = 0; j < word2.length(); j++) {
                if (word2.charAt(j) == c) {
                    count2++;
                }
            }

            if (count2 != count1) {
                return nao;
            }
        }
        return "SIM";
    }
}
