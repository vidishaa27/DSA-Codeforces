import java.util.*;

public class 2207_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char[] s = sc.next().toCharArray();

            // Maximum number of 1s
            for (int i = 1; i < n - 1; i++) {
                if (s[i - 1] == '1' && s[i + 1] == '1') {
                    s[i] = '1';
                }
            }

            int max = 0;
            for (char c : s) {
                if (c == '1') {
                    max++;
                }
            }

            // Minimum number of 1s
            for (int i = 1; i < n - 1; i++) {
                if (s[i - 1] == '1' && s[i + 1] == '1') {
                    s[i] = '0';
                }
            }

            for (int i = 1; i < n - 1; i++) {
                if (s[i - 1] == '1' && s[i + 1] == '1') {
                    s[i] = '0';
                }
            }

            int min = 0;
            for (char c : s) {
                if (c == '1') {
                    min++;
                }
            }

            System.out.println(min + " " + max);
        }

        sc.close();
    }
}