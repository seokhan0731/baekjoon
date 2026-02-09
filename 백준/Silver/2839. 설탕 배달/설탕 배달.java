import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 코드 3. 그리디 알고리즘 사용
 * 코드1, 2는 DP를 사용하여 해결, 해당 문제는 [1463. 1로 만들기]와 비슷해보이지만 그리디 활용 가능
 * '1로 만들기'에서는 세 가지 선택이 존재하며, 1을 빼는 경우, 최선의 선택이 3으로 나누는 것인지,
 *  2로 나누는 것인지에 대해 판별 불가능 -> 주어진 조건에서 조건에 맞춘 최선의 선택 불가
 *      but 해당 문제에서는 5로 나누어떨어진다면 5로 나누어버리고, 그게 아니면 3을 뺀다라는 단일 최선의 행동 존재
 *
 * +) 처음에는 해당 문제를 그리디 알고리즘으로 풀 수 있다는 사실에, 5를 뺄 수 있다면, 5를 뺀다라는 선택으로 구현하고자 했으니,
 *     11과 같은 예외가 존재한다는 것을 파악
 *     결국 해당 문제는 5i+3k에서 i를 최대로 만들거나, k를 최소화하는 두 가지 루트가 있는데, i를 매번 증가시키며, 확인하는 것보다,
 *     역으로 접근하여, k를 증가시키면서 i의 자리를 찾는 것이 올바른 최선의 선택이 된다.
 *
 * 그리디를 단순히 크기를 중요시하지 않고, 기준을 생각해야된다. 기준의 최우선 순위를 잡고, 그 상태에 맞게 행동을 한다면,
 * 그게 곧 최선의 선택이지, 단순히 크기만 생각한다면, 거스름돈 문제같은 그리디 알고리즘 문제만 해결 가능하지, 이러한 그리디 알고리즘은 해결 불가
 */
public class Main2 {
    static int getMinimumWayByGreedy(int target) {
        int count = 0;
        while (target >= 0) {
            if (target % 5 == 0) {
                count += target / 5;
                break;
            }
            target -= 3;
            count++;
        }
        if (target < 0) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(getMinimumWayByGreedy(n));
    }
}
/**
 * 코드 2. 탑다운 방식 이용
 * 바텀업 방식과는 별개로, 두 가지 상수값을 정의하여 사용하였다.
 * 기존 바텀업 방식에서는 INF로 배열의 값을 채운 상태에서, 단순히 min을 비교하여 사용하였지만,
 * 탑다운 방식에서의 메모이제이션을 위해, 별도의 방문여부를 판단하는 NONVISITED라는 상수를 사용함.
 * * 로직은 다음과 같음
 * 방문을 하지 않은 상태면 NONVISITED, 재귀를 통해 값을 줄여나갈때, idx가 음수가 되는 경우 INF
 * idx가 음수가 되는 경우 -> 문제에서 -1이 나오는 조건 or 1과 2(입력 조건에 맞지 않음)
 * <p>
 * 처음 탑다운 방식으로 구현했을 때는, 바텀업 방식과 동일하게 INF로 값을 채워
 * idx가 0인 경우->메모이제이션 확인->3보다 큰 경우->5보다 큰 경우 비교하기 순을 거쳤지만,
 * 메모이제이션에서 단순히 INF인 경우, 진짜 방문을 한건지, 값을 못 구하는지 알 방도가 없어서 다음과 같이 코드를 수정
 */
//public class Main2 {
//    static final int INF = 9999;
//    static final int NONVISITED = -1;
//
//    static int getMinimumWay(int[] array, int targetIdx) {
//        if (targetIdx < 0) {
//            return INF;
//        }
//        if (targetIdx == 0) {
//            return 0;
//        }
//
//        if (array[targetIdx] != NONVISITED) {
//            return array[targetIdx];
//        }
//
//        array[targetIdx] = Math.min(getMinimumWay(array, targetIdx - 3),
//                getMinimumWay(array, targetIdx - 5)) + 1;
//
//        return array[targetIdx];
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] array = new int[n + 1];
//
//        Arrays.fill(array, NONVISITED);
//
//        int answer = getMinimumWay(array, n);
//        if (answer >= INF) {
//            System.out.println(answer);
//            return;
//        }
//        System.out.println(-1);
//    }
//}

/**
 * 기존 풀이
 * dp 바텀업 방식을 사용하여, 입력으로 주어진 n까지의 최소 봉지 개수를 구해준다.
 * Math.min을 비교하기 용이하도록, 출력 조건인 -1 대신, INF라는 변수값을 도출될 수 없는 큰 값으로 지정하여 이용한다.
 * 초기값은 INF로 채운 뒤, 별도로 idx=0인 경우에만 특수 지정하면, idx=3부터는 주어진 규칙에 맞게 값을 채워주면 된다.
 * <p>
 * +) 초기에 문제를 풀 때는, if-else if-else문을 통해서 코드의 가독성이 상당히 떨어짐
 * idx: 0~length
 * 1. 0인 경우, 별도 지정
 * 2. 3보다 작은 경우 -1 채우기
 * 3. 그 외 경우 5 미만인 경우, array[idx-3]인 경우 등 여러가지를 분기하였음
 * <p>
 * => 결국 큰 값으로 미리 값을 채운 뒤, 주어진 조건에 맞게 Math.min을 사용하는 것이 여러모로 바텀업 방식에서 유리한듯?
 */
//public class Main2 {
//    static final int INF = 9999;
//
//    static void getMinimumWay(int[] array) {
//        array[0] = 0;
//        for (int i = 3; i < array.length; i++) {
//            array[i] = Math.min(array[i - 3] + 1, array[i]);
//
//            if (i >= 5) {
//                array[i] = Math.min(array[i - 5] + 1, array[i]);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] array = new int[n + 1];
//        Arrays.fill(array, INF);
//
//
//        getMinimumWay(array);
//
//        int target = array[n];
//        if (target != INF) {
//            System.out.println(target);
//            return;
//        }
//        System.out.println(-1);
//    }
//}
