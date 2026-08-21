import java.util.*;

public class YouDeleteIDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s);

            int zeroIndex = -1;

            // Alice's move
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '1') {
                    zeroIndex = i;
                    break;
                }
            }

            if (zeroIndex == -1) {
                for (int i = sb.length() - 1; i >= 0; i--) {
                    if (sb.charAt(i) == '0') {
                        zeroIndex = i;
                        break;
                    }
                }
            }

            sb.deleteCharAt(zeroIndex);

            // Bob's move
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '1') {
                    sb.deleteCharAt(i);
                    break;
                }
            }

            System.out.println(sb);
        }
    }
}