package graph.algorithms;

//The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem.
//The problem is to find shortest distances between every pair of vertices in a 
//given edge weighted directed Graph. 

public class FloydWarshallAllPairsShortestPath {

	final static int INF = 99999;

	void floydWarshall(int graph[][], int V)
	    {
	        int dist[][] = new int[V][V];
	        
	        for(int i=0;i<V;i++) {
	        	for(int j=0;j<V;j++) {
	        		dist[i][j]=graph[i][j];
	        	}
	        }
	        
	        for(int k=0;k<V;k++) {
	        	for(int i=0;i<V;i++) {
	        		for(int j=0;j<V;j++) {
	        			if(dist[i][k]+dist[k][j]<dist[i][j])
	        				dist[i][j]=dist[i][k]+dist[k][j];
	        		}
	        	}
	        }
	        printSolution(dist,V);
	    }

	 void printSolution(int dist[][], int V)
	    {
	        System.out.println("The following matrix shows the shortest "+
	                         "distances between every pair of vertices");
	        for (int i=0; i<V; ++i)
	        {
	            for (int j=0; j<V; ++j)
	            {
	                if (dist[i][j]==INF)
	                    System.out.print("INF ");
	                else
	                    System.out.print(dist[i][j]+"   ");
	            }
	            System.out.println();
	        }
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Let us create the following weighted graph
        10
     (0)------->(3)
     |         /|\
     5 |          |
     |          | 1
     \|/         |
     (1)------->(2)
        3           */
     int graph[][] = { {0,   5,  INF, 10},
                       {INF, 0,   3, INF},
                       {INF, INF, 0,   1},
                       {INF, INF, INF, 0}
                     };
     FloydWarshallAllPairsShortestPath obj= new FloydWarshallAllPairsShortestPath();
     obj.floydWarshall(graph, 4);

	}

}
