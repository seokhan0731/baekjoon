import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void getMinimumCount(int[] array) {
        int i = 4;
        while (i < array.length) {
            int way = i;
            if (i % 3 == 0) {
                way = Math.min(way, array[i / 3] + 1);
            }
            if (i % 2 == 0) {
                way = Math.min(way, array[i / 2] + 1);
            }
            way = Math.min(way, array[i - 1] + 1);

            array[i] = way;
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
        }
        else if (n == 2 || n == 3) {
            System.out.println(1);
        }
        else {
            int[] array = new int[n + 1];

            //초기값 지정
            array[1] = 0;
            array[2] = 1;
            array[3] = 1;

            getMinimumCount(array);

            System.out.println(array[n]);

        }
    }
}