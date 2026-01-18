import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 람다식을 통해 정렬 조건 커스텀
 * 1-1. 메소드 시그니처: Arrays.sort(T[] a, Comparator<? super T> c)
 *      정렬 대상(a)
 *      람다식: (Comparator c) ->{...} 이 꼴로 작성
 * 1-2.람다식 내부의 코드는 c언어의 strcmp()와 같은 부호에 따른 선후 관계
 *          (-): 기존 순서 유지(제대로 되어있는 상태)
 *          0: 서로 동일
 *          (+): 자리 바꿈
 *
 * 2. 중복 제거 패턴
 * 초기 버전에서는 n=1인 경우를 생각을 못해, i=0부터 i+1과 비교하여 i를 출력
 * (?): n=1인 경우 별도 분기 처리 필요, 끝의 두 원소에 대한 별도 처리 필요
 * => i=0 별도 출력 이후, i와 i-1 비교를 통한 i 출력 처리로 리팩토링
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = br.readLine();
        }
        Arrays.sort(array, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        sb.append(array[0]).append('\n');
        for (int i = 1; i < n; i++) {
            if (!array[i - 1].equals(array[i])) {
                sb.append(array[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
