import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            long prefix = 0;
            long minAvg = Long.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                long x = Long.parseLong(st.nextToken());
                prefix += x;

                minAvg = Math.min(minAvg, prefix / i);

                out.append(minAvg).append(" ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}