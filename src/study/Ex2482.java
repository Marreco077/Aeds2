package study;

import java.util.Scanner;

public class Ex2482 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberLanguages = scanner.nextInt();
        scanner.nextLine();

        String[] arrLanguages = new String[numberLanguages];
        String[] arrTranslate = new String[numberLanguages];

        for (int i = 0; i < numberLanguages; i++) {
            String languages = scanner.nextLine();
            String translate = scanner.nextLine();

            arrLanguages[i] = languages;
            arrTranslate[i] = translate;

        }

        int numberNames = scanner.nextInt();
        scanner.nextLine();

        String[] arrNames = new String[numberNames];

        for(int i = 0; i < numberNames; i++) {
            String name = scanner.nextLine();

            arrNames[i] = name;
            String language = scanner.nextLine();

            for(int j = 0; j < numberLanguages; j++) {
                if (language.equals(arrLanguages[j])) {
                    System.out.println(name);
                    System.out.println(arrTranslate[j]);
                    System.out.println();
                    break;
                }
            }
        }
    }
}

