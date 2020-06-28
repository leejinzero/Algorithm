import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
	static int numCount ;
	static boolean [] visited;
	static char[] tem;
	static List<Character> list ;
	static int[] solution ;
	static long min=Integer.MAX_VALUE;
	static long max=Integer.MIN_VALUE;
	static long result;
	
	public static void calc(int index){
		if(index==tem.length) {	
			return ;
		}
		if(tem[index]=='+') {
			result += solution[index+1];
		}
		else if(tem[index]=='-') {
			result -= solution[index+1];
		}
		else if(tem[index]=='*') {
			result *= solution[index+1];
		}
		else {
			result /= solution[index+1];
		}
		calc(index+1);
	}
	
	public static void permu(int index) {
		if(index==numCount-1) {
			result= solution[0];
			calc(0);
			min = Math.min(min,result);
			max = Math.max(max,result);
			return;
		}
		for (int i = 0; i < numCount-1; i++) {
			if(!visited[i]) {
				tem[index]= list.get(i);
				visited[i]=true;
				permu(index+1);
				visited[i]=false;
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		numCount = Integer.parseInt(bf.readLine());
		solution = new int[numCount];
		
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		for (int i = 0; i < numCount; i++) {
			solution[i]= Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(bf.readLine());
		list = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(tokens.nextToken());
			char tem = '0' ;
			if (i==0) tem ='+';
			else if(i==1) tem ='-';
			else if(i==2) tem ='*';
			else if(i==3) tem='/';
			
			for (int j = 0; j < cnt; j++) {
				list.add(tem);
			}
		}
		visited= new boolean[numCount-1];
		tem = new char[numCount-1];
		permu(0);
		
		System.out.println(max);
		System.out.println(min);
	}

}
