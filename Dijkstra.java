import java.util.*;
import java.io.*;

class Dijkstra{
    private int V;
    private LinkedList<Pair> adj[];

    Dijkstra(int v)
    {
        this.V=v;
        
        adj=new LinkedList[v];
       
        for(int i=0;i<v;i++)
        {
            adj[i]= new LinkedList<Pair>();
        }
    }
    void addEdge(int a, int b,int weight)
    {
        adj[a].add(new Pair(b,weight));
        adj[b].add(new Pair(a,weight));
    }

    void dijstra(Dijkstra graph,int src,int mindist[]){
        TreeSet<Pair> set = new TreeSet<>(new MyComparator());
        
        set.add(new Pair(src,0));
        // System.out.print(src);
        mindist[src]=0;
        
        while(!set.isEmpty())
        {
           
            Pair current= set.pollFirst();
            // System.out.println(current.b+" "+current.weight);
            for(Pair pair: graph.adj[current.b])
            {
                if((mindist[current.b]+pair.weight)<mindist[pair.b])
                {
                    // System.out.println(mindist[current.b]+pair.weight+" "+mindist[pair.b]+" re");
                    // set.remove(pair);
                    mindist[pair.b]=mindist[current.b]+pair.weight;
                    set.add(new Pair(pair.b,mindist[current.b]+pair.weight));
                }
                
            }
             
            
        }
        // System.out.println();
        
    }

    public static void main(String args[])
    {
        Dijkstra graph= new Dijkstra(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8) ;
        graph.addEdge(1, 2, 8) ;
        graph.addEdge(1, 7, 11) ;
        graph.addEdge(2, 3, 7) ;
        graph.addEdge(2, 8, 2) ;
        graph.addEdge(2, 5, 4) ;
        graph.addEdge(3, 4, 9) ;
        graph.addEdge(3, 5, 14) ;
        graph.addEdge(4, 5, 10) ;
        graph.addEdge(5, 6, 2) ;
        graph.addEdge(6, 7, 1) ;
        graph.addEdge(6, 8, 6) ;
        graph.addEdge(7, 8, 7) ;
        int mindist[]=new int[graph.V];
        for(int i=0;i<graph.V;i++)
        {
            mindist[i]=Integer.MAX_VALUE;
        }
        graph.dijstra(graph,0,mindist);
        for(int i=0;i<graph.V;i++)
        {
            System.out.print(mindist[i]+" ");
        }

    }

    class Pair 
    {
        int b;
        int weight;
      
        Pair(int b , int weight){
        
            this.b=b;
            this.weight=weight;
        }
       

    }
    static class MyComparator implements Comparator<Pair>
    {
        @Override
        public int compare(Pair s1, Pair s2) {
            // System.out.print(s1.weight);
            // System.out.print(" comparator ");
            // System.out.print(s2.weight);
            if(s1.weight==s2.weight)
                return 0;
            else if(s1.weight>s2.weight)
                return 1;
            else return -1;
           
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        Long nextLong(){
            return Long.parseLong(next());
        }
        String nextLine(){
            String line="";
            try{
                line= br.readLine();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return line;
        }
    }
}