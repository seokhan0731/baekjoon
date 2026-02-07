import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int INF = 9999;

    static void getMinimumWay(int[] array) {
        array[0] = 0;
        for (int i = 3; i < array.length; i++) {
            array[i] = Math.min(array[i - 3] + 1, array[i]);
            
            if (i >= 5) {
                array[i] = Math.min(array[i - 5] + 1, array[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        Arrays.fill(array, INF);


        getMinimumWay(array);

        int target = array[n];
        if (target != INF) {
            System.out.println(target);
            return;
        }
        System.out.println(-1);
    }
}