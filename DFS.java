import java.util.*;
import java.io.*;

class DFS{
    private int V;
    private LinkedList<Integer> adj[];
    DFS(int v){
        this.V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<>();
        }

    }
    void addEdge(int a , int b)
    {
        adj[a].add(b);
        adj[b].add(a);
    }


    void dfs(DFS graph,int src,boolean visited[]){
        System.out.print(src+" ");
        visited[src]=true;
        for(Integer node: graph.adj[src]){
            if(!visited[node]){
                dfs(graph,node,visited);
            }   
        }

    }
    public static void main(String args[])
    {
        DFS graph= new DFS(4);
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
        boolean visited[]= new boolean[4];
        graph.dfs(graph,2,visited);
        
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String line="";
            try{
                line=br.readLine();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return line;

        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
