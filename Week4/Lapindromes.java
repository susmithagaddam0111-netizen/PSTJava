import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();

            int[] freq = new int[26];

            // first half
            for (int i = 0; i < n / 2; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // second half (skip middle if odd)
            for (int i = (n + 1) / 2; i < n; i++) {
                freq[s.charAt(i) - 'a']--;
            }

            boolean isLapindrome = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    isLapindrome = false;
                    break;
                }
            }

            System.out.println(isLapindrome ? "YES" : "NO");
        }
        sc.close();
    }
}
