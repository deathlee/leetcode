package leetcode;

public class KthLargest {
	public static void main(String args[]) {
		KthLargest kthLargest=new KthLargest();
		int nums[]={2,1};
		kthLargest.findKthLargest(nums, 2);
	}
    public int findKthLargest(int[] nums, int k) {
        
        int left=0;
        int right=nums.length-1;
        return quickSelect(left,right,nums,k);
    }
    int quickSelect(int left,int right,int nums[],int k){
        int pval=nums[right];
        int storeIdx=left;
        for(int i=left;i<right;i++){
            if(nums[i]<=pval){
                swap(nums,storeIdx,i);
                storeIdx++;
            }
        }
        swap(nums,storeIdx,right);
        if(k==storeIdx){
            return nums[storeIdx];
        }else if(k>storeIdx){
            return quickSelect(storeIdx+1,right,nums,k);
        }else{
            return quickSelect(left,storeIdx-1,nums,k);
        }
    }
    void swap(int []nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
