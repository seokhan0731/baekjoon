import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] searchingArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            searchingArray[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] targetArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targetArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(searchingArray);
        for(int i=0;i<m;i++){
            if(Arrays.binarySearch(searchingArray,targetArray[i])>=0){
                sb.append(1).append('\n');
                continue;
            }
            sb.append(0).append('\n');
        }
        System.out.println(sb);
    }
}
