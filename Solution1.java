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