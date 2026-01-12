import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int findMax(int[] originScore) {
        int max = originScore[0];
        for (int i = 1; i < originScore.length; i++) {
            if (originScore[i] > max) {
                max = originScore[i];
            }
        }
        return max;
    }

    static double[] editNewScore(int[] originScore, int max) {
        double[] newScore = new double[originScore.length];
        for (int i = 0; i < originScore.length; i++) {
            newScore[i] = (double) originScore[i] / max * 100;
        }
        return newScore;
    }

    static double getAverage(double[] newScore) {
        double sum = 0;
        for (int i = 0; i < newScore.length; i++) {
            sum += newScore[i];
        }
        return sum / newScore.length;
    }

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] originScore = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            originScore[i] = Integer.parseInt(st.nextToken());
        }
        int max = findMax(originScore);
        double[] newScore = editNewScore(originScore, max);
        double average = getAverage(newScore);
        sb.append(average);
        System.out.println(sb);
    }
}
