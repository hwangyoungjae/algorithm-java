package softeer.p7628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            divisor(Integer.parseInt(st.nextToken())).forEach(integer -> {
                map.put(integer, map.getOrDefault(integer, 0) + 1);
            });
        }
        System.out.println(Collections.max(map.values()));
    }

    public static List<Integer> divisor(int value) {
        int sqrt = (int) Math.sqrt(value);
        List<Integer> arr = new ArrayList<>(sqrt);
        for (int i = 1; i <= sqrt; i++) {
            if (value % i == 0) {
                if (i != 1) {
                    arr.add(i);
                }
                if (value / i != i) {
                    arr.add(value / i);
                }
            }
        }
        return arr;
    }
}

