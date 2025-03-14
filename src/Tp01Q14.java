import java.util.Scanner;
import java.io.RandomAccessFile;

public class Tp01Q14 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("./file.txt", "rw");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            file.writeDouble(scanner.nextDouble());
        }
        file.close();

        file = new RandomAccessFile("./file.txt", "r");
        for (int i = n - 1; i >= 0; i--) {
            file.seek(i * 8);
            double num = file.readDouble();
            if (num == (int) num) {
                System.out.println((int) num);
            } else {
                System.out.println(num);
            }
        }
        file.close();
        scanner.close();
    }
}
