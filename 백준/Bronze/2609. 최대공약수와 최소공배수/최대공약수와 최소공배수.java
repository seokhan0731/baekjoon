import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int getGcd(int smallNumber, int bigNumber) {
        int k = 2;
        while (k <= smallNumber) {
            if ((smallNumber % k == 0) && (bigNumber % k == 0)) {
                return k * getGcd(smallNumber / k, bigNumber / k);
            }
            k++;
        }
        return 1;
    }

    static int getLcm(int smallNumber, int bigNumber, int gcd) {
        int x = smallNumber / gcd;
        int y = bigNumber / gcd;
        if (y % x == 0) {
            return bigNumber;
        }
        return gcd * x * y;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int smallNumber;
        int bigNumber;

        if (Integer.compare(a, b) > 0) {
            bigNumber = a;
            smallNumber = b;
        }
        else {
            bigNumber = b;
            smallNumber = a;
        }
        int gcd = getGcd(smallNumber, bigNumber);
        int lcm = getLcm(smallNumber, bigNumber, gcd);

        sb.append(gcd).append('\n');
        sb.append(lcm);

        System.out.println(sb);
    }
}