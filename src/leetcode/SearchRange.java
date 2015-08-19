package leetcode;

public class SearchRange {
	public static void main(String args[]) {
		int nums[]=new int[1];
		nums[0]=1;
		searchRange(nums, 0);
	}
    public static int[] searchRange(int[] nums, int target) {
        int range[]=new int[2];
        range[0]=-1;
        range[1]=-1;
        int mark=-1;
        int low=0;
        int high=nums.length-1;
        int mid=(low+high)/2;
        while(low<=high){
            if(nums[mid]==target){
                mark=mid;
                break;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        int left=mark-1;
        int right=mark+1;
        while((left>=0&&nums[left]==target)||(right<nums.length&&nums[right]==target)){
            if(left>=0&&nums[left]==target){
                left--;
            }
            if(right<nums.length&&nums[right]==target){
                right++;
            }
        }
        range[0]=left+1;
        range[1]=right-1;
        return range;
    }

}
