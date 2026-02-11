import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
         int currentMax = arr.get(0);
    int maxSoFar = arr.get(0);

    int nonContiguousSum = 0;
    int maxElement = arr.get(0);
    if (arr.get(0) > 0) {
        nonContiguousSum = arr.get(0);
    }

    for (int i = 1; i < arr.size(); i++) {
        int num = arr.get(i);
        currentMax = Math.max(num, currentMax + num);
        maxSoFar = Math.max(maxSoFar, currentMax);
        if (num > 0) {
            nonContiguousSum += num;
        }

        maxElement = Math.max(maxElement, num);
    }
    if (nonContiguousSum == 0) {
        nonContiguousSum = maxElement;
    }

    return Arrays.asList(maxSoFar, nonContiguousSum);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
