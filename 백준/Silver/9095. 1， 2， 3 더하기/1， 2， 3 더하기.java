import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int[] array = new int[12];
    static StringBuilder sb = new StringBuilder();

    static void calculateNumberOfCases() {
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        calculateNumberOfCases();
        for (int i = 0; i < n; i++) {
            sb.append(array[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }
}


/**
 * 기존 코드. 해시맵을 사용해 탑다운 방식의 dp 구현
 * 값을 저장한 채, 불필요한 계산을 최소화하는 것이 dp의 이유이므로,
 * 만약 key가 저장되어 있지 않다면, 저장 후, 값을 반환하고, 그게 아니라면 매핑되어있는 값을 반환하는 방식으로 해시맵 사용
 * 1,2,3을 더해서 만드는 경우는 dp[n-1]+1, dp[n-2]+2, dp[n-3]+3의 경우로만 존재하고, 해당 순서는 끝에 1, 2, 3을 더하므로
 * 중복되는 수가 존재할 수가 없는 구조
 * 이에 따라, 초기 1,2,3 값만 매핑을 완료 후, dp[n]=dp[n-1]+dp[n-2]+dp[n-3]으로 dp 점화식 구성
 * <p>
 * <p>
 * +) hashmap 관련
 * 처음에는 getOrDefault를 사용했지만, 이는 dp에서 메모이제이션을 하지 못한다.
 * getOrDefault가 key가 없으면, default값을 저장하고 사용하는 줄 알았지만, key가 없으면 default 값을 반환만 하도록 구성된 메소드
 * 의도대로 동작하기 위해서는 아래 코드에서의 두 가지 방법이 존재
 * -1. containsKey+put 메소드 이용
 * -2. computeIfAbsent 메소드 이용: 람다식을 사용하여, 저장하고 반환할 수 있는 메소드로 반드시 알아둬야할듯
 */
//public class Main2 {
//    static HashMap<Integer, Integer> memoizationMap = new HashMap<>();
//    static StringBuilder sb = new StringBuilder();
//
//    static int getNumberOfCases(int target) {
//        if (!memoizationMap.containsKey(target)) {
//            int result = getNumberOfCases(target - 1) + getNumberOfCases(target - 2)
//                    + getNumberOfCases(target - 3);
//            memoizationMap.put(target, result);
//            return result;
//        }
//
//        return memoizationMap.get(target);
//    }
//
/// /    static int getNumberOfCases(int target) {
/// /        return memoizationMap.computeIfAbsent(target, key ->
/// /                getNumberOfCases(key - 1) + getNumberOfCases(key - 2)
/// /                        + getNumberOfCases(key - 3)
/// /        );
//
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        memoizationMap.put(1, 1);
//        memoizationMap.put(2, 2);
//        memoizationMap.put(3, 4);
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            int target = Integer.parseInt(br.readLine());
//            sb.append(getNumberOfCases(target)).append('\n');
//        }
//        System.out.println(sb);
//    }
//}