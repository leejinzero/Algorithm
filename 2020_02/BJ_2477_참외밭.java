import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2477_참외밭 {
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int weight = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			int dir = Integer.parseInt(tokens.nextToken());
			int len = Integer.parseInt(tokens.nextToken());
			list.add(len);			
		}
		
		long total_sum=0;
		int max_sum=0;
		int result;
		for (int i = 0; i < list.size(); i++) {
			if(i==list.size()-1) {
				result = list.get(i)*list.get(0);
			}else {
				result = list.get(i)*list.get(i+1);
			}	
			total_sum+= result;
			
			if(max_sum<result) {
				max_sum=result;
			}
		}
		
		long minus =total_sum - 3*max_sum;
		
		System.out.println((max_sum+minus)*weight);
		
	}

}
