import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = null;

        String line = reader.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            line = reader.readLine();
            while (line == null || line.trim().isEmpty()) {
                line = reader.readLine();
            }
            int n = Integer.parseInt(line.trim());
            int len = 2 * n;

            int[] a = new int[len + 1];
            int[] first = new int[n + 1];
            int[] last = new int[n + 1];

            line = reader.readLine();
            while (line == null || line.trim().isEmpty()) {
                line = reader.readLine();
            }
            tokenizer = new StringTokenizer(line);

            for (int i = 1; i <= len; i++) {
                if (!tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                a[i] = Integer.parseInt(tokenizer.nextToken());
                if (first[a[i]] == 0) {
                    first[a[i]] = i;
                } else {
                    last[a[i]] = i;
                }
            }

            long[] dp = new long[len + 1];

            for (int i = 1; i <= len; i++) {
                dp[i] = dp[i - 1];

                // If i is the second occurrence of a pair
                if (last[a[i]] == i) {
                    int L = first[a[i]];
                    int curr = i;

                    // Expand L to include all elements that overlap with the current interval
                    while (curr >= L) {
                        L = Math.min(L, first[a[curr]]);
                        curr--;
                    }

                    long length = i - L + 1;
                    dp[i] = Math.max(dp[i], dp[L - 1] + length * length);
                }
            }

            output.append(dp[len]).append("\n");
        }

        System.out.print(output);
    }
}