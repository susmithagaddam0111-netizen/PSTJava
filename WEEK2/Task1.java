import java.util.*;
import java.util.stream.*;

public class SecondHighest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = list.stream()
                .distinct()                         // remove duplicates
                .sorted(Comparator.reverseOrder())  // sort descending
                .skip(1)                            // skip highest
                .findFirst()                        // get second highest
                .orElse(-1);                        // if not exists

        System.out.println(result);
    }
}
