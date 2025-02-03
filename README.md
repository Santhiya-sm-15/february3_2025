# february3_2025
The problems that I solved today

1.You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing

Code:
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length,i;
        int r=1,max=0,cnt=0;
        while(r<n)
        {
            if(nums[r-1]<nums[r])
                cnt++;
            else
            {
                max=Math.max(max,cnt+1);
                cnt=0;
            }
            r++;
        }
        max=Math.max(max,cnt+1);
        cnt=0;
        r=1;
        while(r<n)
        {
            if(nums[r-1]>nums[r])
                cnt++;
            else
            {
                max=Math.max(max,cnt+1);
                cnt=0;
            }
            r++;
        }
        max=Math.max(max,cnt+1);
        return max;
    }
}

2.Given a maze with N cells. Each cell may have multiple entry points but not more than one exit(i.e entry/exit points are unidirectional doors like valves). You are given an array Edge[] of N integers, where Edge[i] contains the cell number that can be reached from of cell i in one step. Edge[i] is -1 if the ith cell doesn't have an exit. The task is to find the largest sum of a cycle in the maze(Sum of a cycle is the sum of the cell indexes of all cells present in that cycle). Note:The cells are named with an integer value from 0 to N-1. If there is no cycle in the graph then return -1.

Code:
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

3.Given a maze with n cells. Each cell may have multiple entry points but not more than one exit point (i.e entry/exit points are unidirectional doors like valves). You are given an array exits[], where exits[i] contains the exit point of the ith cell. If exits[i] is -1, then ith cell doesn't have an exit. The task is to find the cell with maximum weight (The weight of a cell i is the sum of all the cell indexes that have exit point as i ). If there are multiple cells with the maximum weight return the cell with highest index. Note: The cells are indexed with an integer value from 0 to n-1. A cell i has weight 0 if no cell has exit point as i.

Code:
class Solution {
    public int maxWeightCell(int[] exits) {
        int n=exits.length;
        int i;
        int[] indegree=new int[n];
        for(i=0;i<n;i++)
        {
            if(exits[i]!=-1)
            indegree[exits[i]]+=i;
        }
        int max=0,node=-1;
        for(i=0;i<n;i++)
        {
            if(indegree[i]>=max)
            {
                max=indegree[i];
                node=i;
            }
            max=Math.max(max,indegree[i]);
        }
        return node;
    }
}
