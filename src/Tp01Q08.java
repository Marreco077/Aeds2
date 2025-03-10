import java.util.Scanner;

public class Tp01Q08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String numbersString = scanner.nextLine();

            if(numbersString.equals("FIM")) {
                break;
            }
            int numbers = Integer.parseInt(numbersString);

            System.out.println(sum(numbers));
        }

        scanner.close();
    }

    public static int sum(int numbers) {

        if(numbers < 10) {
            return numbers;
        }
        else {
            return  (numbers % 10) + sum(numbers / 10);
        }
    }
}
