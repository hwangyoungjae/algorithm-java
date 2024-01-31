package softeer.p6280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int r = 2;

        for (int i = 0; i < n; i++) {
            r = r + (r - 1);
        }
        System.out.println(r * r);
    }
}
