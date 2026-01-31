import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static final StringBuilder sb = new StringBuilder();
    static int k;

    static void makeJosephusPermutation(Deque<Integer> queue) {
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offerLast(queue.pollFirst());
            }

            sb.append(queue.pollFirst());
            if (!queue.isEmpty()) {
                sb.append(", ");
                continue;
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Deque<Integer> circularQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            circularQueue.offerLast(i + 1);
        }

        sb.append('<');
        makeJosephusPermutation(circularQueue);
        sb.append('>');

        System.out.println(sb);
    }
}