import java.util.Scanner;
import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(arr);

        if (k > 0 && k <= n) {
            System.out.println(arr[k - 1]);
        } else {
            System.out.println("Invalid K");
        }
    }
}

