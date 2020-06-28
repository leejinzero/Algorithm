import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SWEA_7701_염라대왕의이름정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			Set<String> tset = new TreeSet<>();
			sb.append("#"+tc).append("\n");
			int N = Integer.parseInt(bf.readLine());
			int maxlen = 0;
			
			for (int i = 0; i < N; i++) {
				String tem = bf.readLine();
				maxlen = Math.max(maxlen, tem.length());
				tset.add(tem);
			}
			
			boolean[] visited = new boolean[tset.size()];
			for (int i = 1; i <=maxlen; i++) {
				int idx=0;
				for (String s : tset) {
					if(!visited[idx] && s.length()==i) {
						sb.append(s).append("\n");
						visited[idx]= true;
					}
					idx++;
				}
			}	
		}

		System.out.println(sb);
	}

}
