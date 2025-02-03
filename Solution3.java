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