import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int numberOfSide = 3;
    static int[] array;
    static final StringBuilder sb = new StringBuilder();

    static void isRightTriangle() {
        Arrays.sort(array);
        if (array[2] * array[2] != array[0] * array[0] + array[1] * array[1]) {
            sb.append("wrong").append('\n');
            return;
        }
        sb.append("right").append('\n');
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        array = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numberOfSide; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            if (array[0] == 0 && array[1] == 0 && array[2] == 0) {
                break;
            }
            isRightTriangle();
        }
        System.out.println(sb);
    }
}