import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 처음에 어떻게 접근해야될지 생각했을 때, 9012번 괄호 문제를 풀 때, 사용했던 카운터 방식이나, 스택을 응용해서
 * 풀고자 하였지만, 이건 해당 문제와 성향이 다르기 때문에 불가능함
 * 카운터나 스택 방식에서는 절대적인 위치가 크게 상관없고, 절대적인 위치의 경우가 흰색 시작, 검정 시작 두 경우로
 * 나뉘기 떄문에, 적용 불가능
 * => 카운터, 스택 방식은 데이터의 순서나 개수로 균형을 맞추는 문제에 용이, 절대적인 정보를 기억해야하는 경우는 사용 불가능
 */

/**
 * 기존 코드
 * 브루트포스 알고리즘 사용
 * 1. 입력의 체스판을 검정색이면 true, 흰색이면 false로 2차원 배열에 저장
 * => int, String의 배열로 저장하는 것보다 메모리 절약 가능   (두 가지 값으로 구분되는건 boolean으로 받자!)
 * 2. 바깥기준 2번째 루프까지는 모든 경우의 수 순회, 안쪽 2개 루프는 8*8 체스판 순회로 유효한 체스판인지 확인
 * => 체스판을 순회할 때, 두 가지 사실 이용
 *      -1. 시작하는 타일의 색은 상관없이 하나에 조건으로 수정해야할 타일의 수(n)를 세면
 *          , 다른 색의 체스판인 경우 64-n으로 구해진다.
 *      -2. 동일 타일이 들어가야하는 인덱스는 행 idx+열 idx의 합이 모두 짝수이거나, 홀수여야만 한다.
 * 3. 결국 최소값을 구해야하는 문제이기 때문에, 최소값만 갱신하면 되며, 이에 따라 굳이 전에 구해두었던 수정 타일 개수는
 *    기억할 필요가 없다.
 *
 *    +) 해당 문제에서는 DP의 누적합 구조를 사용한다면 더 최적화 가능 (class 3 문제 풀면서 DP 학습 필요)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //가로
        int m = Integer.parseInt(st.nextToken());   //세로

        boolean[][] board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int k = 0; k < m; k++) {
                if (line.charAt(k) == 'B') {
                    board[i][k] = true;
                    continue;
                }
                board[i][k] = false;
            }
        }

        int min = 65;
        for (int i = 0; i <= n - 8; i++) {
            for (int k = 0; k <= m - 8; k++) {
                int count = 0;

                for (int x = i; x < i + 8; x++) {
                    for (int y = k; y < k + 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (!board[x][y]) {
                                count++;
                            }
                            continue;
                        }
                        if (board[x][y]) {
                            count++;
                        }
                    }

                }
                if (Math.min(count, 64 - count) < min) {
                    min = Math.min(count, 64 - count);
                }
            }

        }
        System.out.println(min);
    }


}
