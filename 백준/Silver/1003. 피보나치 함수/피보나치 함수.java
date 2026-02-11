import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp = new int[41][3];
    static StringBuilder sb = new StringBuilder();

    static void calculateNumberOfZeroAndOne() {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int k = 0; k < 2; k++) {
                dp[i][k] = dp[i - 1][k] + dp[i - 2][k];
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        calculateNumberOfZeroAndOne();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(' ').append(dp[n][1]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}