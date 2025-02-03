class Solution{
    ArrayList<Integer>[] adj;
    List<Integer> temp;
    public long dfs(int src,int p,int[] visited,int[] parent)
    {
        visited[src]=1;
        parent[src]=p;
        temp.add(src);
        for(int a:adj[src])
        {
            if(visited[a]==0)
            {
                long r=dfs(a,src,visited,parent);
                if(r!=-1)
                    return r;
            }
            else if(visited[a]==1)
            {
                long sum=a;
                while(src!=a)
                {
                    sum+=src;
                    src=parent[src];
                }
                if(src==a)
                    return sum;
                return -1;
            }
        }
        return -1;
    }
    public long largesSumCycle(int N, int Edge[]){
        adj=new ArrayList[N];
        temp=new ArrayList<>();
        int i;
        for(i=0;i<N;i++)
            adj[i]=new ArrayList<>();
        for(i=0;i<N;i++)
        {
            if(Edge[i]!=-1)
                adj[i].add(Edge[i]);
        }
        int[] visited=new int[N];
        int[] parent=new int[N];
        long max=-1;
        for(i=0;i<N;i++)
        {
            if(visited[i]==0)
            {
                max=Math.max(max,dfs(i,-1,visited,parent));
                for(int j:temp)
                    visited[j]=2;
                temp.clear();
            }
        }
        return max;
    }
}