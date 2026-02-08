import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
public class Main2 {
    static final int INF = 9999;
    static final int NONVISITED = -1;

    static int getMinimumWay(int[] array, int targetIdx) {
        if (targetIdx < 0) {
            return INF;
        }
        if (targetIdx == 0) {
            return 0;
        }

        if (array[targetIdx] != NONVISITED) {
            return array[targetIdx];
        }

        array[targetIdx] = Math.min(getMinimumWay(array, targetIdx - 3),
                getMinimumWay(array, targetIdx - 5)) + 1;

        return array[targetIdx];
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];

        Arrays.fill(array, NONVISITED);

        int answer = getMinimumWay(array, n);
        if (answer >= INF) {
            System.out.println(answer);
            return;
        }
        System.out.println(-1);
    }
}

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
