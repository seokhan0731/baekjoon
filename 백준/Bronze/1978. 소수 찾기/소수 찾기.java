import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static boolean isDecimal(int number) {
        int i = 2;
        int count = 0;
        while (i <= number) {
            if (number % i == 0) {
                count++;
            }
            i++;
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numArray = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        int decimalCount = 0;
        for (int i = 0; i < n; i++) {
            if (isDecimal(numArray[i])) {
                decimalCount++;
            }
        }

        sb.append(decimalCount);
        System.out.println(sb);
    }
}
