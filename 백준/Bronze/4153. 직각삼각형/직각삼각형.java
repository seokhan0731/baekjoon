import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 기존 코드
 * 정렬을 통해, 마지막 원소가 가장 크다는 조건 하에, 피타고라스 공식 전개
 * 초기에는 Math.max()사용하려했지만, 세 변 중, 어떤 변이 max인지 기억을 하기 위해 로직이 복잡해짐을
 * 깨닫고, array[]사용
 * +) pow사용해서 제곱수를 구하려고도 했지만, 매개 변수나 그러한 것들이 double이기 때문에 단순 곱 구조로 코드 작성
 *    pow보다 이 구조과 정수 연산에서 더 유리(오차 및 연산 속도 부분에서 더 유리)
 */
public class Main {
    static final int numberOfSide = 3;
    static int[] array;
    static final StringBuilder sb = new StringBuilder();

    static void isRightTriangle() {
        Arrays.sort(array);
        if (array[2] * array[2] != array[0] * array[0] + array[1] * array[1]) {
            sb.append("wrong").append('\n');
            return;
        }
        sb.append("right").append('\n');
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        array = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numberOfSide; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            if (array[0] + array[1] + array[2] == 0) {
                break;
            }
            isRightTriangle();
        }
        System.out.println(sb);
    }
}