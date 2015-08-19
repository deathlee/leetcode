package leetcode;

public class MajorElement {
	public static void main(String args[]){
		int nums[]={6,5,5};
		majorityElement(nums);
	}
    public static int majorityElement(int[] nums) {
        int count=1;
        int major=nums[0];
        for(int i=1;i<nums.length;i++){
            if(major==nums[i]){
                count++;
            }
            else if(count==0){
                count++;
                major=nums[i];
            }else{
                count--;
            }
        }
        return major;
    }

}
