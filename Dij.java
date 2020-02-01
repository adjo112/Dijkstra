public class Dij
{
    private static void Dijkstra(int[][] matrix, int s){
        int n = matrix.length;
        //0 to n-1 vertex
        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            dis[i] = Integer.MAX_VALUE;
            visited[i]=false;
        }
        dis[s]=0;
        for(int i=0;i<n;i++){
            int vertex = minimumDist(dis,visited);
            //if reachable vertex
            if(vertex!=Integer.MAX_VALUE){
                visited[vertex]=true;
                for(int j=0;j<n;j++){
                    if(matrix[vertex][j]>0){
                        int newdist = dis[vertex]+ matrix[vertex][j];
                        dis[j]=Math.min(dis[j],newdist);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println("vertex-"+i+"dis"+dis[i]);
        }
    }
    private static int minimumDist(int[] dis,boolean[] visited){
        int d = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int i=0;i<dis.length;i++){
            if(!visited[i] && dis[i]<d){
                d = dis[i];
                j = i;
            }
        }
        return j;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra(matrix,0);
    }
}