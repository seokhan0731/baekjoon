import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Integer> memoizationMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static int getNumberOfCases(int target) {
        if (target == 1 || target == 2 || target == 3) {
            return memoizationMap.get(target);
        }

        return memoizationMap.getOrDefault(target, getNumberOfCases(target - 1) + getNumberOfCases(target - 2)
                + getNumberOfCases(target - 3));
    }


    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memoizationMap.put(1, 1);
        memoizationMap.put(2, 2);
        memoizationMap.put(3, 4);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(getNumberOfCases(target)).append('\n');
        }
        System.out.println(sb);
    }
}