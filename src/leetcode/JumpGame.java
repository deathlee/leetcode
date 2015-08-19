package leetcode;

public class JumpGame {
	public static void main(String args[]) {
		int nums[]={1,2};

		jump(nums);
	}
    public static int jump(int[] nums) {
        int len=nums.length-1;
        int step=0;
        int index=0;
        int maxPosition=nums[0];
        if(maxPosition>=len&&len==0){
            step=0;
        }else{
            step=1;
        }
        while(maxPosition<len){
            step++;
            int maxRange=0;
            for(int i=index;i<=maxPosition;i++){
                if(i+nums[i]>maxRange){
                    maxRange=i+nums[i];
                    index=i;
                }
            }
            maxPosition=maxRange;
        }
        return step;
    }
        
    

}
