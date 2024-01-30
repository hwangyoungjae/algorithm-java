package softeer.p7368;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int a;
    private static int b;
    private static int d;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

//        System.out.println(solutionA());
        System.out.println(solutionB());
    }

    private static int solutionA() {
        int i = 0;
        int j;
        int t;

        // a 움직임, b 멈춤
        j = d;
        while (true) {
            t = Math.min(j, a);
            j -= t;
            i += t; // 이동
            if (j <= 0) {
                break;
            }
            i += b; // 멈춤
        }

        // a 멈춤, b 움직임
        j = d;
        while (true) {
            t = Math.min(j, b);
            j -= t;
            i += t; // 이동
            if (j <= 0) {
                break;
            }
            i += a; // 멈춤
        }
        return i;
    }

    private static int solutionB() {
        return calcDistance(a, b, d) + calcDistance(b,a,d);
    }

    private static int calcDistance(int x, int y, int d) {
        if (x >= d) {
            return d;
        } else {
            int c = d / x;
            int forwardTime = c * x;
            int idleTime = c * y;
            return forwardTime + idleTime + (d - forwardTime);
        }
    }
}
