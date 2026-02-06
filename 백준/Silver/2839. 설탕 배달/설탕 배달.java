import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void getMinimumWay(int[] array) {
        for (int i = 5; i < array.length; i++) {
            if (array[i - 3] == -1 && array[i - 5] == -1) {
                array[i] = -1;
                continue;
            }   //array[i-3]!=-1 || array[i-5]!=-1
            else if (array[i - 3] != -1 && array[i - 5] == -1) {
                array[i] = array[i - 3] + 1;
            }
            else if (array[i - 5] != -1 && array[i - 3] == -1) {
                array[i] = array[i - 5] + 1;
            }
            else {
                array[i] = Math.min(array[i - 3], array[i - 5]) + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];

        array[0] = 0;
        array[1] = -1;
        array[2] = -1;


        array[3] = 1;
        if (n > 3) {
            array[4] = -1;
            getMinimumWay(array);
        }
        System.out.println(array[n]);
    }
}