import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 코드2. 탑다운 방식의 dp사용
 * 기존 코드와 로직과 동일하게, dp[n]=dp[n-2]+dp[n-1]의 점화식을 사용했고,
 * 재귀의 종료 조건을 idx=0, 1인 경우, 1을 뱉어 idx=2인 경우 2가 되게끔 코드 구성
 *
 * 형재는 Integer[]로 선언하여, null로 초기값을 할당하였지만,
 * int[]로 하여 INF값을 나누는 수인 10007 이상의 값으로 설정하여, 메모이제이션을 사용하였다면,
 * 성능적으로 더 우수한 코드를 완성 했을듯?(객체 생성 비용X)
 */
public class Main {
    static final int divideNumber = 10007;

    static int getNumberOfCases(Integer[] dp, int targetIndex) {
        if (targetIndex == 1 || targetIndex == 0) {
            return 1;
        }
        if (dp[targetIndex] != null) {
            return dp[targetIndex];
        }

        dp[targetIndex] = (getNumberOfCases(dp, targetIndex - 1)
                + getNumberOfCases(dp, targetIndex - 2)) % divideNumber;

        return dp[targetIndex];
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] dp = new Integer[n + 1];

        System.out.println(getNumberOfCases(dp, n));
    }
}

/**
 * 기존 코드. 바텀업 방식의 dp 사용
 * 결국 해당 문제에서 타일을 채우는 경우는 두 가지이다.
 * 1*2 타일을 두 개를 배치하여, 2*2 사이즈를 채우는 방법과, 2*1의 타일을 단일로 배치하여 2*1 사이즈를 채우는 방법이디.
 *  이에 따라, n이 +1이 된다면, 후자의 방법만 가능하며, dp[n]=dp[n-1]의 경우의 수를 따르게 된다,
 *           n이 +2 된다면, 전자의 방법만 가능하며, dp[n]=dp[n-2]의 경우의 수를 따르게 된다.
 *              이 두 사실을 종합하면, 최종적으로 dp[n]=dp[n-2]+dp[n-1]이라는 점화식을 최종적으로 도출할 수 있다.
 *
 * +) 나머지 법칙 관련
 *    해당 문제에서 또 한 가지 눈 여겨봐야하는 것은 나머지 법칙이다. 만약 n의 입력 제한선까지 구하여, 모든 값을 계산 후,
 *    출력 시에만 10007로 나눈다면, 중간 과정에서의 오버플로우가 발생하여, 의도치 않은 답이 나온다.
 *      이에 따라, [나머지끼리의 합=기존 합의 나머지]로 성립된다는 나머지 법칙을 이용해야 한다.
 *      n=q1*k+r1 + q2*k+r2일때, 각 나머지는, r1과 r2가 된다.
 *      전체 식을 전개하여 정리하면 n=k(q1+q2)+r1+r2이므로, 동일하게 r1+r2가 되므로 해당 법칙은 성립이 가능하다.
 *
 * +) 기존 접근 방식 사고
 *  처음에 해당 문제를 접했을 때는, 넓이의 개념으로 접근을 하고자 했지만, 그렇게 된다면 1*2 타일과 2*1 타일을 구분할 방법이 없었으며,
 *  직접 다차원 배열로 시뮬레이션을 해볼까도 싶었지만, 배열에 값을 채워 넣는 방식이 너무 복잡해져, 이 접근 방식도 아니라고 단정을 지었다.
 *
 *  DP는 결국 시뮬레이션적 사고를 하지 않는 것이 중요하다. 결국 상태의 변화량만이 중요한 것이 dp이며,
 *  물리적인 실체나 양을 직접 계산할 필요는 없다. 이 사실을 반드시 명심해야할듯?
 *  상태의 변화량만이 중요한 것이지, 해당 물리적 과정은 알 필요가 없다!
 */
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

