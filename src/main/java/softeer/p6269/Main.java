package softeer.p6269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int M, N, K;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder secretKeys = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int m = 0; m < M; m++) {
            secretKeys.append(st.nextToken());
        }

        StringBuilder userKeys = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int n = 0; n < N; n++) {
            userKeys.append(st.nextToken());
        }

        if (userKeys.toString().contains(secretKeys)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}
