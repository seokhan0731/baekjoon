import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 초창기 풀이 알고리즘 구상
 * 처음에는 그리디 알고리즘을 통해 풀고자 접근
 * 1. m보다 작은 수 중, 가장 큰 수(a)를 선택
 * 2. m-a보다 작은 수 중, 가장 큰 수(b)를 선택
 * 3. m-a-b보다 작은 수 중, 가장 큰 수(c)를 선택
 * <p>
 * 하지만, a를 너무 큰 숫자로 뽑게 된다면, b+c 조합 중, 해당 조건을 만족하는 카드가 존재하지 않을 수 있기 때문에 부적합 판단
 * => 이에 따라, 모든 경우의 수를 탐색하는 브루트포스 알고리즘 선택
 *
 * +) m보다 3개의 숫자 합이 작거나 같으면서 최댓값을 찾으면 되니, m>=sum 조건하에 max>sum은 기억할 필요 X
 * => 추가적인 메모리 절약 가능
 */
public class Main {
    static int findMax(int[] arr, int goal) {
        int length = arr.length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int k = i + 1; k < length - 1; k++) {
                for (int j = k + 1; j < length; j++) {
                    sum = arr[i] + arr[k] + arr[j];
                    if (max < sum && sum <= goal) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = findMax(arr, m);
        sb.append(max);
        System.out.println(sb);
    }
}
