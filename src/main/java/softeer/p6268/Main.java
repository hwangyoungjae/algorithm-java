package softeer.p6268;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final static int F = 5;
    private static final int[] BCODE = {
            Integer.parseInt("1111110", 2),
            Integer.parseInt("0000110", 2),
            Integer.parseInt("1011011", 2),
            Integer.parseInt("1001111", 2),
            Integer.parseInt("0100111", 2),
            Integer.parseInt("1101101", 2),
            Integer.parseInt("1111101", 2),
            Integer.parseInt("1100110", 2),
            Integer.parseInt("1111111", 2),
            Integer.parseInt("1101111", 2),
    };
    private static int testCase;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        int result;
        for (int no = 0; no < testCase; no++) {
            result = 0;

            st = new StringTokenizer(bf.readLine());
            Integer[] a = stringToArray(st.nextToken());
            Integer[] b = stringToArray(st.nextToken());
            for (int i = 0; i < F; i++) {
                result += diffN(a[i], b[i]);
            }
            System.out.println(result);
        }
    }

    public static Integer[] stringToArray(String string) {
        Integer[] arr = new Integer[F];
        for (int i = 0; i < F; i++) {
            int j = i - (F - string.length());
            if (j >= 0) {
                arr[i] = Character.getNumericValue(string.charAt(j));
            }
        }
        return arr;
    }

    public static int diffN(Integer a, Integer b) {
        if (a != null && b != null) {
            return getBinaryOnCount(BCODE[a] ^ BCODE[b]);
        } else if (a != null) {
            return getBinaryOnCount(BCODE[a]);
        } else if (b != null) {
            return getBinaryOnCount(BCODE[b]);
        }
        return 0;
    }

    public static int getBinaryOnCount(int n) {
        return getBinaryOnCount(Integer.toBinaryString(n));
    }

    public static int getBinaryOnCount(String binary) {
        return (int) binary.chars()
                .filter(c -> c == '1')
                .count();
    }
}
