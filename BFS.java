import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Graph{
    
    private int V;
    private LinkedList<Integer> adj[];
    Graph(int v){
        this.V=v;
        adj= new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<Integer>();
        }
    }

    void addEdge(int a, int b)
    {
        adj[a].add(b);
        adj[b].add(a);
    }
    

    void bfs(Graph g,int src)
    {
        boolean visited[]=new boolean[g.V];
        visited[src]=true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        while(!queue.isEmpty())
        {
            int current= queue.poll();
            System.out.print(current+" ");
            
            for(Integer i : g.adj[current])
            {
                if(!visited[i])
                {
                    queue.add(i);
                    visited[i]=true;
                }
            }

        }


    }
    public static void main(String[] args) {
        Graph g= new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

        g.bfs(g,2);

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
    
            while(st==null || !st.hasMoreTokens())
            {
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
            
        }
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            }   
            catch (Exception e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
        int nextInt(){
            return Integer.parseInt(next());
        }
        Double nextDouble(){
            return Double.parseDouble(next());
        }
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
}


