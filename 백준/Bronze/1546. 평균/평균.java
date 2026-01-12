import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double calculate(int arr[]) {
        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return (double) 100 / (arr.length * max) * sum;
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

        double average = calculate(originScore);

        sb.append(average);
        System.out.println(sb);
    }

}


/**
 * 기존 풀이
 * 1. 배열을 통해 입력 받기
 * 2. 최댓값 탐색, 보정, 평균 구하는 메소드 내부에서 각각 반복문을 돌고, 추가적인 메모리를 더 쓰는 비효율 존재
 *
 */
//public class Main {
//    /**
//     * 최댓값 찾기
//     *
//     * @param originScore 기존 입력받은 점수값의 배열
//     * @return 최댓값
//     */
//    static int findMax(int[] originScore) {
//        int max = originScore[0];
//        for (int i = 1; i < originScore.length; i++) {
//            if (originScore[i] > max) {
//                max = originScore[i];
//            }
//        }
//        return max;
//    }
//
//    /**
//     * 보정값 제작
//     *
//     * @param originScore 기존 입력받은 점수값의 배열
//     * @param max         최댓값
//     * @return 보정된 점수값의 배열
//     */
//    static double[] editNewScore(int[] originScore, int max) {
//        double[] newScore = new double[originScore.length];
//        for (int i = 0; i < originScore.length; i++) {
//            newScore[i] = (double) originScore[i] / max * 100;
//        }
//        return newScore;
//    }
//
//    /**
//     * 평균 구하기
//     *
//     * @param newScore 보정된 점수값의 배열
//     * @return 최종 도출된 평균
//     */
//    static double getAverage(double[] newScore) {
//        double sum = 0;
//        for (int i = 0; i < newScore.length; i++) {
//            sum += newScore[i];
//        }
//        return sum / newScore.length;
//    }
//
//    public static void main(String[] args) throws IOException {
//
/// /        System.setIn(new FileInputStream("input.txt"));
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int n = Integer.parseInt(br.readLine());
//
//        int[] originScore = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            originScore[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int max = findMax(originScore);
//        double[] newScore = editNewScore(originScore, max);
//        double average = getAverage(newScore);
//
//        sb.append(average);
//        System.out.println(sb);
//    }
//}
