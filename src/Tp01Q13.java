import java.util.Scanner;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tp01Q13 {
    private static String httpRequest(String url) {
        URL site;
        InputStream inputStream;
        BufferedReader bufferedReader;
        String response = "";
        String line;

        try {
            site = new URI(url).toURL();
            inputStream = site.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine()) != null) {
                response += line + "\n";
            }

            inputStream.close();
        } catch (Exception e) { }

        return response;
    }

    private static void countVowels(String site, char[] vowels, int[] tag) {
        int[] vowelCount = new int[vowels.length];

        for (int j = 0; j < vowels.length; j++) {
            for (int i = 0; i < site.length(); i++) {
                if (site.charAt(i) == vowels[j]) {
                    vowelCount[j]++;
                }
            }
            vowelCount[0] -= (1 * tag[1]);
            vowelCount[1] -= (0.5 * tag[1]);

            System.out.print(vowels[j] + "(" + vowelCount[j] + ") ");
        }
    }

    private static void countConsonants(String site, char[] consonants, int[] tag) {
        int consonantCount = 0;

        for (int j = 0; j < consonants.length; j++) {
            for (int i = 0; i < site.length(); i++) {
                if (site.charAt(i) == consonants[j]) {
                    consonantCount++;
                }
            }
        }
        consonantCount -= (2 * tag[0]);
        consonantCount -= (3 * tag[1]);

        System.out.print("consoante(" + consonantCount + ") ");
    }

    private static int[] countTags(String site, String[] tags) {
        int[] tagCount = new int[tags.length];

        for (int j = 0; j < tags.length; j++) {
            for (int i = 0; i < site.length(); i++) {
                if (site.charAt(i) == tags[j].charAt(0) && i + tags[j].length() <= site.length()) {
                    int check = tags[j].length();
                    boolean isEqual = true;

                    for (int k = 0; k < check; k++) {
                        if (tags[j].charAt(k) != site.charAt(i + k)) {
                            isEqual = false;
                        }
                    }
                    if (isEqual) {
                        tagCount[j]++;
                    }
                }
            }
        }
        return tagCount;
    }

    private static void countElements(String title, String url) {
        String site = httpRequest(url);

        char[] vowels = { 'a', 'e', 'i', 'o', 'u', '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', '\u00E3', '\u00F5', '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB' };
        char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
        String[] tags = {"<br>", "<table>"};

        int[] tag = countTags(site, tags);

        countVowels(site, vowels, tag);

        countConsonants(site, consonants, tag);

        for (int i = 0; i < tag.length; i++) {
            System.out.print(tags[i] + "(" + tag[i] + ") ");
        }

        System.out.println(title);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine();
        String url;

        while (!(title.length() == 3 && title.charAt(0) == 'F' && title.charAt(1) == 'I' && title.charAt(2) == 'M')) {
            url = sc.nextLine();
            countElements(title, url);

            title = sc.nextLine();
        }

        sc.close();
    }
}
