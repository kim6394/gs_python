import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1922 {
	
	static class Edge {
		int target;
		int value;
		
		Edge(int target, int value) {
			this.target = target;
			this.value = value;
		}
	}
	
	static ArrayList<Edge>[] list;
	static int[] direction;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		direction = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
			direction[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end, val));
			list[end].add(new Edge(start, val));
		}
		
		int start = 0;
		direction[start] = 0;
		visited[start] = true;
		int answer = 0;
		
		while(true) {
			
			for (int i = 0; i < list[start].size(); i++) {
				
				int target = list[start].get(i).target;
				int value = list[start].get(i).value;
				
				if(!visited[target]) {
					if(direction[target] > value) direction[target] = value;
				}
			}
			
			int min = Integer.MAX_VALUE;
			boolean isEnd = true;
			
			for (int i = 0; i < direction.length; i++) {
				
				if(visited[i] || direction[i] == Integer.MAX_VALUE) continue;
				
				if(direction[i] < min) {
					min = direction[i];
					start = i;
					isEnd = false;
				}
			}
			
			if(isEnd) break;
			
			visited[start] = true;
			answer += min; 
			
		}
		
		System.out.println(answer);
	}

}
