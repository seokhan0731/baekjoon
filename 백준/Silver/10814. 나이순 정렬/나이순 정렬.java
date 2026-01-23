import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 기존 코드
 * 클래스의 배열을 통해, Arrays.sort 람다식을 활용한 정렬 수행
 *
 * 최적화를 한다면, 지금 코드에서는 signUpOrder가 필요가 없음
 * Arrays.sort()-> 듀얼 퀵소트 or 팀소트
 * -1. 듀얼 퀵소트: 자료형이 원시 자료형인 경우(int, float, char...)
 * -2. 팀소트: 자료형이 객체인 경우(Integer, String, Class...)
 *
 * 듀얼 퀵소트는 unstable하기 때문에, 정렬 기준이 같더라도 순서가 바뀔 수 있지만,
 * 팀소트는 stable하여 순서가 바뀌지 않는다.
 * => 해당 문제에서는 나이가 같다면, 기존에 들어온 순서 기준으로 정렬 수행이기 때문에, 굳이 signUpOrder가 없어도
 *    팀소트를 활용하여 정렬하였으면 답을 도출할 수 있었다.
 */
public class Main {
    static class Member {
        int age;
        String name;
        int signUpOrder;

        public Member(int age, String name, int signUpOrder) {
            this.age = age;
            this.name = name;
            this.signUpOrder = signUpOrder;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Member[] array = new Member[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(array, (a, b) -> {
            if (a.age != b.age) {
                return Integer.compare(a.age, b.age);
            }
            return Integer.compare(a.signUpOrder, b.signUpOrder);
        });

        for(int i=0;i<n;i++){
            sb.append(array[i].age)
                    .append(' ')
                    .append(array[i].name)
                    .append('\n');
        }
        System.out.println(sb);
    }
}