import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Tp01Q20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while(true) {
            String words = scanner.nextLine();

            if (words.equals("FIM")) {
                break;
            }
            else {
                System.out.printf("%s %s %s %s", isVowel(words), isConsonant(words), isInteger(words), isReal(words));
                System.out.println("");
            }
        }
    }

    public static String isVowel(String words) {
        int len = words.length();
        words = words.toLowerCase();

        for(int i = 0; i < len; i++) {
            if (words.charAt(i) != 'a' && words.charAt(i) != 'e' && words.charAt(i) != 'i' && words.charAt(i) != 'o' && words.charAt(i) != 'u') {
                return "NAO";
            }
        }
        return "SIM";
    }

    public static String isConsonant(String words) {
        words = words.toLowerCase();

        Pattern p = Pattern.compile("^[bcdfghjklmnpqrstvwxyz]+$");
        Matcher m = p.matcher(words);
        boolean b = m.matches();

        if (b) {
            return "SIM";
        }
        return "NAO";
    }

    public static String isInteger(String words) {
        int number;
        try {
            number = Integer.parseInt(words);
            return "SIM";
        }
        catch (NumberFormatException e) {
            return "NAO";
        }
    }

    public static String isReal(String words) {
        double number;
        words = words.replace(",", ".");

        try {
            number = Double.parseDouble(words);
            return "SIM";
        }
        catch (NumberFormatException e) {
            return "NAO";
        }
    }
}
