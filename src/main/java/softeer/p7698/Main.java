package softeer.p7698;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    private static final String oneVote = "|";
    private static final String fiveVote = "++++";
    private static final int fiveVoteN = 5;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(bf.readLine());
        for (int i = 0; i < c; i++) {
            printVotes(Integer.parseInt(bf.readLine()));
        }
    }

    private static void printVotes(int voteNumber) {
        List<String> sArr1 = new ArrayList<>();
        List<String> sArr2 = new ArrayList<>();

        IntStream.range(0, voteNumber / fiveVoteN).forEach(value -> sArr1.add(fiveVote));
        IntStream.range(0, voteNumber % fiveVoteN).forEach(value -> sArr2.add(oneVote));

        System.out.print(String.join(" ", sArr1));
        if (!sArr1.isEmpty() && !sArr2.isEmpty()) {
            System.out.print(" ");
        }
        System.out.println(String.join("", sArr2));
    }
}
