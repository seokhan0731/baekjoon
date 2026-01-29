import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 풀이 2
 * 재귀함수 구현
 * 파스칼 정의에 따라 nCk = n-1Ck-1 + n-1Ck 재귀로 구현
 * +) 여기서는 이미 구한 조합이여도, 나올 때마다 구할 수 밖에 없음
 * => DP를 통해, 이미 구한 조합값은 다시 안 구하도록 하는게 best
 *    (DP는 Class 3에서 접할 것!)
 */
public class Main {
    static int getBinomialCoefficientByRecursion(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return getBinomialCoefficientByRecursion(n - 1, k - 1) + getBinomialCoefficientByRecursion(n - 1, k);
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        System.out.println(getBinomialCoefficientByRecursion(n, k));
    }
}


/**
 * 기존 코드
 * 분자, 분모 각각 해당하는 횟수만큼 곱해서, 답 도출
 * n의 범위가 10 이하로 정해져있기 때문에, 소규모 연산의 경우, 커버 가능
 * but 숫자의 범위가 커지는 경우, 해당 풀이는 매우 부적절
 */
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        int productOfNumerator = 1;
//        int productOfDenominator = 1;
//        for (int i = k; i > 0; i--) {
//            productOfNumerator *= n;
//            productOfDenominator *= i;
//            n--;
//        }
//        System.out.println(productOfNumerator / productOfDenominator);
//    }
//}