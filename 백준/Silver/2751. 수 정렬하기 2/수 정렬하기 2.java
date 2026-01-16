import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. stream()을 통한 sout 반복 vs stringbuilder() 사용
 * 1-1. sout 반복 -> 화면에 띄우기 위해 OS와 반복적인 소통 필요 + 버퍼 플러시 등의 부가적인 작업 증가
 * 1-2. stringbuilder()로 append 이후 출력 -> append를 하는 상황에서는 부가적인 비용 필요 X
 * => 일반적으로 입력데이터가 크지 않은 경우에는 sout써도 무방 but 입력데이터가 크거나 시간제한이 빠듯한 경우는
 * 무조건 stringbuilder 방식 채용 (10^5 or 10^6기준점으로 사용할 것)
 * <p>
 * 2. Arrays.sort(int[]) vs Collections.sort()
 * 2-1. 듀얼 퀵소트: 피벗 두개 잡고 퀵소트 돌리는 것과 동일
 * => 퀵소트의 한계점인 기정렬된 데이터 집합에서는 최악의 성능 발휘 -> O(n^2), 평균적으로는 O(nlogn)
 * 2-2. 팀 소트: 합병정렬 + 삽입 정렬
 * => 최악, 최선, 평균에 대한 큰 편차가 존재 X -> O(nlogn)
 * but 같은 시간복잡도여도 웬만하면 듀얼 퀵소트가 더 속도 빠름
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for (int value : list) {
            sb.append(value).append('\n');
        }

        System.out.println(sb);
    }
}
