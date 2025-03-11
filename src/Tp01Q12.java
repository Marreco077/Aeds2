import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tp01Q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            String passwords = scanner.nextLine();

            if (passwords.equals("FIM")) {
                break;
            }

            System.out.println(validPassword(passwords));
        }
    }

    public static String validPassword(String passwords) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passwords);

        if (matcher.matches()) {
            return "SIM";
        }
        return "NAO";
    }
}
