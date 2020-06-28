import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17271_리그오브레전설 {
	public static int dp[][] = new int[10001][10001];
	public static int combi(int n , int r){
		if(r==0 || n==r) {
			return 1;
		}
		if(dp[n][r] >0) return dp[n][r];
		return dp[n][r] = (combi(n-1,r-1)%1000000007+combi(n-1,r)%1000000007)%1000000007;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		
		int time = Integer.parseInt(tokens.nextToken());
		int m_time = Integer.parseInt(tokens.nextToken());
		int total_case=0;
		
		for (int i = 0; i <= time/m_time; i++) {
			int count = time-i*m_time + i;
			total_case = (total_case + combi(count, i))%1000000007;
		}
		System.out.println(total_case);
	}
}
