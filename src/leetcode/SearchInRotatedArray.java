package leetcode;

public class SearchInRotatedArray {
	public static void main(String args[]) {
		SearchInRotatedArray searchInRotatedArray=new SearchInRotatedArray();
		int num[]={4,5,6,7,8,0,1,2};
		System.out.println(searchInRotatedArray.search(num, 5));
	}

    public int search(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        int mid=(begin+end)/2;
        int idx= binarySearchMid(nums,begin,mid,end);
        int result=0;
        if (target<=nums[end]) {
			begin=idx;
			mid=(begin+end)/2;
			result=binarySearch(nums,begin,mid,end,target);
		}else{
			end=idx-1;
			mid=(begin+end)/2;
			result=binarySearch(nums,begin,mid,end,target);
		}
        return result;
    }
    private int binarySearch(int[] nums, int begin, int mid, int end,
			int target) {
    	if (begin>end) {
			return -1;
		}
    	if (target>nums[mid]) {
			begin=mid+1;
			mid=(begin+end)/2;
			return binarySearch(nums,begin,mid,end,target);
		}else if(target<nums[mid]){
			end=mid-1;
			mid=(begin+end)/2;
			return binarySearch(nums,begin,mid,end,target);
		}else{
			return mid;
		}
    }

	int binarySearchMid(int[] num,int begin,int mid,int end){
        if(begin>end)return 0;
        if(num[mid]>num[end]){
            begin=mid+1;
            mid=(begin+end)/2;
            return binarySearchMid(num,begin,mid,end);
        }else if(num[mid]<num[end]){
            end=mid;
            mid=(begin+end)/2;
            return binarySearchMid(num,begin,mid,end);
        }else{
            return mid;
        }
    }
}
