package softeer.p7626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int minDistance = 1000000;
        int minDistanceCount = 0;
        int previousPos = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int pos = Integer.parseInt(st.nextToken());
            int distance = pos - previousPos;
            if (distance < minDistance) {
                minDistance = distance;
                minDistanceCount = 1;
            } else if (distance == minDistance) {
                minDistanceCount++;
            }
            previousPos = pos;
        }
        System.out.println(minDistanceCount);
    }
}
