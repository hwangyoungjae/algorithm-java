package softeer.p7353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        assert 2 <= n;
        assert n <= 100;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] pool = new int[n];
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            pool[i] = p;
        }

        int r = 0;
        if (n == 2) {
            r = pool[0] * pool[1];
        } else {
            for (int i = 0; i < pool.length; i++) {
                for (int j = i + 1; j < pool.length; j++) {
                    if (r < pool[i] * pool[j]) {
                        r = pool[i] * pool[j];
                    }
                }
            }
        }

        System.out.println(r);
    }
}
