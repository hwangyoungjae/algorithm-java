import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        String[] arr = {"a", "b"};
        String[] newArr = Arrays.copyOfRange(arr, 0, 4);
        System.out.println(Arrays.toString(newArr));
    }
}
