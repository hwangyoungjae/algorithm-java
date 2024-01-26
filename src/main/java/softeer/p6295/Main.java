package softeer.p6295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int numberOfCases;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        numberOfCases = Integer.parseInt(bf.readLine());
        for (int i = 0; i < numberOfCases; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            System.out.printf("Case #%d: %d%n", i + 1, Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        }
    }
}
