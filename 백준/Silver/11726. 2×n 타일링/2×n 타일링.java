import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int divideNumber = 10007;

    static void getNumberOfCases(int[] dp) {
        int length = dp.length;
        if (length <= 2) {
            return;
        }
        for (int i = 2; i < length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % divideNumber;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        getNumberOfCases(dp);
        System.out.println(dp[n]);
    }
}