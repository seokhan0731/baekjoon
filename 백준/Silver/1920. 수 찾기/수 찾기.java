import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 코드2. HashSet 사용(존재 여부 판단, 중복 제거)
 * 자체적인 해시 함수를 사용하여, 분류의 최적화 되어있음
 * => 바로 다이렉트로 존재 여부 확인 가능(즉시 접근) (O(1))
 * 단일 원소에 대한 접근은 HashSet이 절대적으로 빠르다!!
 * but 범위 검색의 경우에는 치명적(일일이 다 뒤져봐야 하니까) cuz 순서가 없기 때문에
 * +) 객체를 저장해야하기 때문에 메모리 더 크게 잡아 먹는다!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (set.contains(target)) {
                sb.append(1).append('\n');
                continue;
            }
            sb.append(0).append('\n');
        }

        System.out.println(sb);
    }
}


/**
 * 기존 코드(이진 탐색 이용)
 * 1. 이진 탐색을 위해 정렬 선행 필수 by Arrays.sort() -> O(nlogn)
 * 2. Java에서의 이진 탐색은 Arrays.binarySearch(탐색 배열, 찾을 값) -> O(logn)
 * => 만약 값이 존재한다면, 해당 idx 반환 -> >=0으로 분기 처리
 * 만약 값이 존재하지 않는다면, 만약 값이 있는 경우, 어디에 들어가야하는지에 대해 -(insertion point)-1 반환
 */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        //System.setIn(new FileInputStream("input.txt"));
//        StringBuilder sb = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] searchingArray = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            searchingArray[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int m = Integer.parseInt(br.readLine());
//        int[] targetArray = new int[m];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < m; i++) {
//            targetArray[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(searchingArray);
//        for(int i=0;i<m;i++){
//            if(Arrays.binarySearch(searchingArray,targetArray[i])>=0){
//                sb.append(1).append('\n');
//                continue;
//            }
//            sb.append(0).append('\n');
//        }
//        System.out.println(sb);
//    }
//}
