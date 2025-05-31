// https://leetcode.com/discuss/post/6798436/google-software-engineer-l3-round-ii-by-kcy4h/
// T(n) : O(Q + V + E)
// Company: Google
import static java.lang.System.*;
import java.util.*;

class Edge{
	int v;
	int w;
	
	Edge(int v, int w){
		this.v = v;
		this.w = w;
	}
	
	@Override
	public String toString(){
		return "("+v+","+w+")";
	}
}

public class GetMaxEdgeWeight {
	List<Edge>[] adj;
	int n;
	int[] maxWeights;
	
	GetMaxEdgeWeight(int n){
		this.n =  n;
		adj = new ArrayList[n];
		maxWeights = new int[n];
		
		for(int i=0; i<n; i++){
			adj[i] = new ArrayList<>();
		}	
	}
	
	@Override
	public String toString(){
		String result = "";
			
		for(int i=0; i<n; i++){
			result += i+" -> "+adj[i]+"\n";
		}
		return result;
	}
	
	void addEdge(int u, int v, int w){
		adj[u].add(new Edge(v, w));
		adj[v].add(new Edge(u, w));
	}
	
	//T(n) : O(E)
	int computeGlobalMaxWeight(){
		int globalMax = -1;
		for(int u=0; u<n; u++){
			for(Edge e : adj[u]){
				globalMax = Math.max(globalMax, e.w);
			}
		}		
		return globalMax;
 	}
	
	
	void preComputeWeights(){
		// Get the maxEdge weight out of all the vertices
		int globalMax = computeGlobalMaxWeight();
		Arrays.fill(maxWeights, globalMax);
		
		for(int u = 0; u<n; u++){
			for(Edge e : adj[u]){
				// Recomputing the maxEdgeWeigth for this 'u' vertex only cause glbalMax will be same for all if there is no edge with weight global max is conencted to a vertex
				if(e.w == globalMax){
					// Max weight globally when current vertex is not considered
					int tempMax = -1;
					
					// Traverse all the edges again to recompute the maxEdgeWeigth, leaving the egdes connected to 'u'
					for(int v=0; v<n; v++){
						//Leaving the edages originating from 'u'
						if(v == u)
							continue;
						for(Edge edge : adj[v]){
							// Leaving the edges going towards 'u'
							if(edge.v != u){
							   tempMax = Math.max(tempMax, edge.w);
							}
						}
					}				
					//Update maxEdgeWeight
					maxWeights[u] = tempMax;
				}
			}
	    }
	}
	
	int getMaxWeight(int src){
		return maxWeights[src];
	}



    /*
	* This solution works for connected graphs only
	* For disconnected graphs need to run a loop for all the vertices Q-temes
    * T(n) : O(Q * (V+E))
	*/	
	
	int bruteForce(int src){
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new ArrayDeque<>();
		visited[src] = true;
		q.add(src);
		int maxEdgeWeight = -1;
		
		while(!q.isEmpty()){
			int u = q.poll();
			
			for(Edge e : adj[u]){
				//Leaving all the edges connecting 'u' while computing max
				if(e.v != src && u != src){
					maxEdgeWeight = Math.max(maxEdgeWeight, e.w);
				}
				
				if(!visited[e.v]){
					visited[e.v] = true;
					q.add(e.v);
				}
			}
		}
		
		return maxEdgeWeight;
	}
	
    public static void main(String[] args) {
	   GetMaxEdgeWeight mew = new GetMaxEdgeWeight(4);
	   mew.addEdge(0, 1, 10);
	   mew.addEdge(2, 1, 30);
	   mew.addEdge(0, 2, 25);
	   mew.addEdge(3, 2, 15);
	   mew.preComputeWeights();
	   out.println(mew.getMaxWeight(2));
	   out.println(mew.bruteForce(2));
    }
}