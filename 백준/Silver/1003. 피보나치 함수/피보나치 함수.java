import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 코드 2. 탑다운 방식의 dp구현
 * 기존 코드의 메인 로직과 마찬가지로, dp[n]=dp[n-1]+dp[n-2] 차용
 * int[][]로 처리하고 싶었으나, INF같은 상수를 정의하기엔 입력값의 마지노선의 값이 너무 크기 때문에,
 * 값이 없음을 Integer[][]로 선언하여, null로 표시
 *
 * +) 자바에서도 c계열과 마찬가지로 다차원 배열은 일차원 배열인데, 해당 요소들은 배열로 보는 관점으로 가능
 *     이에 따라, 초기에는 dp[targetIndex]=[null, null]로 찍히기 때문에, dp[targetIndex]==null인 정상 작동 X
 */
public class Main {
    static Integer[][] dp = new Integer[41][2];
    static StringBuilder sb = new StringBuilder();

    static Integer[] calculateNumberOfZeroAndOne(int targetIndex) {
        if (targetIndex == 0) {
            return new Integer[]{1, 0};
        }
        if (targetIndex == 1) {
            return new Integer[]{0, 1};
        }
        if (dp[targetIndex][0] != null) {
            return dp[targetIndex];
        }
        Integer[] temp1 = calculateNumberOfZeroAndOne(targetIndex - 1);
        Integer[] temp2 = calculateNumberOfZeroAndOne(targetIndex - 2);
        dp[targetIndex][0] = temp1[0] + temp2[0];
        dp[targetIndex][1] = temp1[1] + temp2[1];

        return dp[targetIndex];
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Integer[] answer = calculateNumberOfZeroAndOne(n);
            sb.append(answer[0]).append(' ').append(answer[1]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
/**
 * 기존 풀이. 바텀업 방식의 DP 이용
 * 피보나치 수열은 fibo[n]=fibo[n-1]+fibo[n-2]꼴이며,
 * 이는 즉, n의 0과 1의 출력개수는 n-1과 n-2의 각각의 0과 1의 출력개수를 합친 것과 동일
 * 이에 따라, 0과 1행에만 초기값을 부여하고, 나머지는 dp[n]=dp[n-1]+dp[n-2] 점화식 사용
 * <p>
 * +) 해당 문제에서의 입력값은 40까지로 제한되어 있기 때문에, 고정배열로 크기를 잡고, 선계산 후,
 * 입력값에 따른 value값을 도출하도록 설계
 */
//public class Main2 {
//    static int[][] dp = new int[41][2];
//    static StringBuilder sb = new StringBuilder();
//
//    static void calculateNumberOfZeroAndOne() {
//        dp[0][0] = 1;
//        dp[0][1] = 0;
//        dp[1][0] = 0;
//        dp[1][1] = 1;
//
//        for (int i = 2; i < dp.length; i++) {
//            for (int k = 0; k < 2; k++) {
//                dp[i][k] = dp[i - 1][k] + dp[i - 2][k];
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(br.readLine());
//
//        calculateNumberOfZeroAndOne();
//
//        for (int i = 0; i < t; i++) {
//            int n = Integer.parseInt(br.readLine());
//            sb.append(dp[n][0]).append(' ').append(dp[n][1]);
//            sb.append('\n');
//        }
//        System.out.println(sb);
//    }
//}