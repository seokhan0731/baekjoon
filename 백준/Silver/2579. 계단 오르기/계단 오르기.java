import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int getMaxScore(int[] dp, int[] score) {
        if (dp.length < 4) {
            return Arrays.stream(score).sum();
        }

        dp[1] = score[1];
        dp[2] = dp[1] + score[2];

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(score[i - 1] + dp[i - 3], dp[i - 2]) + score[i];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < score.length; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxScore(dp, score));
    }
}