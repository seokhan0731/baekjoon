import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            int length = input.length();
            boolean isPalindrome = true;
            for (int i = 0; i < length / 2; i++) {
                if (input.charAt(i) != input.charAt(length - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome) {
                sb.append("no").append('\n');
                continue;
            }
            sb.append("yes").append('\n');
        }
        System.out.println(sb);
    }
}
