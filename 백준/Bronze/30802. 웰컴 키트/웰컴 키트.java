import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 코드2. 정수 나눗셈 몫 올림 공식?(나머지 존재시에만 올림) 사용
 * (n+t-1)/t
 * 결국 t로 나누어줄건데, 올림이 무조건 필요하다면 t-1을 더한 후, 나누어 주면 된다.
 * => if) n%t==0 => t-1을 더해주는 것이니, 값에 변화 X
 *    if) n%t!=0=> n%t>=1이니, n-1/t==n/t, 여기서 별도로 t/t==1이므로, 이 경우에, 올림 가능
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int numberOfSize = 6;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[numberOfSize];
        for (int i = 0; i < numberOfSize; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < numberOfSize; i++) {
            sum += (array[i] + t - 1) / t;
        }
        sb.append(sum).append('\n');
        sb.append(n / p).append(' ').append(n % p);

        System.out.println(sb);
    }
}

/**
 * 기존 코드
 * 펜의 경우, 나누기와 나머지를 별도로 구하여 풀이
 * 티셔츠의 경우. 묶음수와 0부터 증가하는 루프변수 k를 곱하여, 발주수보다 높거나 같은 경우 멈추어 누적합으로 풀이
 * => 알고리즘은 문제 요구사항과 맞지만, 티셔츠의 경우 발주수가 늘어나거나, 묶음수가 작다면, 루프를
 * 매번 순회하는 것은 비효율적
 */
//public class Main2 {
//    static StringBuilder sb = new StringBuilder();
//    static final int numberOfSize = 6;
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int[] array = new int[numberOfSize];
//        for (int i = 0; i < numberOfSize; i++) {
//            array[i] = Integer.parseInt(st.nextToken());
//        }
//        st = new StringTokenizer(br.readLine());
//        int t = Integer.parseInt(st.nextToken());
//        int p = Integer.parseInt(st.nextToken());
//
//        int sum = 0;
//        for (int i = 0; i < numberOfSize; i++) {
//            int k = 0;
//            while (true) {
//                if (k * t >= array[i]) {
//                    sum += k;
//                    break;
//                }
//                k++;
//            }
//        }
//        sb.append(sum).append('\n');
//        sb.append(n / p).append(' ').append(n % p);
//
//        System.out.println(sb);
//    }
//}