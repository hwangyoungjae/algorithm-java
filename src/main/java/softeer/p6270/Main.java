package softeer.p6270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] limits = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            limits[i][0] = Integer.parseInt(st.nextToken());
            limits[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] speeds = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            speeds[i][0] = Integer.parseInt(st.nextToken());
            speeds[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] stat = new int[100][2]; // limit, speed
        int n = 0;

        for (int[] arr : limits) {
            for (int i = n; i < n + arr[0]; i++) {
                stat[i][0] = arr[1];
            }
            n += arr[0];
        }

        n = 0;
        for (int[] arr : speeds) {
            for (int i = n; i < n + arr[0]; i++) {
                stat[i][1] = arr[1];
            }
            n += arr[0];
        }

        int maxGap = 0;
        for (int i = 0; i < stat.length; i++) {
            int limit = stat[i][0];
            int speed = stat[i][1];
            int gap = speed - limit;
            if (gap > maxGap) {
                maxGap = gap;
            }
        }
        System.out.println(maxGap);
    }
}
