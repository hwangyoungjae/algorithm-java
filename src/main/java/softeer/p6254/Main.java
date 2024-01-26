package softeer.p6254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalWorkMinutes = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            StringTokenizer sTimeSt = new StringTokenizer(st.nextToken(), ":");
            StringTokenizer eTimeSt = new StringTokenizer(st.nextToken(), ":");
            int sTimeHour = Integer.parseInt(sTimeSt.nextToken());
            int sTimeMin = Integer.parseInt(sTimeSt.nextToken());
            int eTimeHour = Integer.parseInt(eTimeSt.nextToken());
            int eTimeMin = Integer.parseInt(eTimeSt.nextToken());
            int workingHours = eTimeHour - sTimeHour;
            totalWorkMinutes += (workingHours * 60) + (eTimeMin - sTimeMin);
        }
        System.out.println(totalWorkMinutes);
    }
}
