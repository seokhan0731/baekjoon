import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [기존 코드] deque를 통한 queue 자료 구조 구현
 * 기존 stack, queue 라이브러리 속 add, pop등을 사용하면 deque에 있는 first, last 개념과 헷갈림
 * -> deque 라이브러리 속 메소드 사용 숙달 핊요
 *
 * -----------** deque **-----------
 * 앞이 first, 뒤가 last라고 생각하면 된다.
 * add/push -> offer()
 * pop/remove -> poll()
 * +) 앞/뒤 조회 -> peek()
 *
 * => 스택에서는 Last In First Out -> offerLast(), pollLast()
 * => 큐에서는 First In First Out -> offerLast(), pollFirst()
 * ---------------------------------
 */
class Main {
    static int popAndChange(Deque<Integer> queue) {
        while (true) {
            if (queue.size() == 1) {
                return queue.peekLast();
            }
            queue.pollFirst();
            queue.offerLast(queue.peekFirst());
            queue.pollFirst();
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offerLast(i+1);
        }

        System.out.println(popAndChange(queue));
    }
}