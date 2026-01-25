import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

    static final Deque<Integer> queue = new ArrayDeque<>();
    static final StringBuilder sb = new StringBuilder();

    static void controlQueue(String command) {
        if (command.contains("push")) {
            StringTokenizer st = new StringTokenizer(command);
            st.nextToken();
            int pushedNumber = Integer.parseInt(st.nextToken());
            queue.offerLast(pushedNumber);
        }
        if (command.equals("pop")) {
            if (queue.isEmpty()) {
                sb.append(-1).append('\n');
                return;
            }
            sb.append(queue.pollFirst()).append('\n');
        }
        if (command.equals("size")) {
            sb.append(queue.size()).append('\n');
        }
        if (command.equals("empty")) {
            if (queue.isEmpty()) {
                sb.append(1).append('\n');
                return;
            }
            sb.append(0).append('\n');
        }
        if (command.equals("front")) {
            if (queue.isEmpty()) {
                sb.append(-1).append('\n');
                return;
            }
            sb.append(queue.peekFirst()).append('\n');
        }
        if (command.equals("back")) {
            if (queue.isEmpty()) {
                sb.append(-1).append('\n');
                return;
            }
            sb.append(queue.peekLast()).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            controlQueue(command);
        }
        System.out.println(sb);
    }

}