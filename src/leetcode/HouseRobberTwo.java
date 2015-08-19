package leetcode;

public class HouseRobberTwo {
	public static void main(String args[]) {
		int []nums={1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		HouseRobberTwo houseRobberTwo=new HouseRobberTwo();
		houseRobberTwo.rob(nums);
	}
	

    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[nums.length-1]);
        return Math.max(robOne(nums),robTwo(nums));
    }
    int robOne(int []num){
        int table[]=new int[num.length];
        table[0]=num[0];
        table[1]=num[0];
        table[2]=num[2]+num[0];
        for(int i=3;i<num.length-1;i++){
            table[i]=Math.max(table[i-2],table[i-3])+num[i];
        }
        return Math.max(table[num.length-2],table[num.length-3]);
    }
    int robTwo(int []num){
        
        int table[]=new int[num.length];
        table[0]=0;
        table[1]=num[1];
        table[2]=0;
        for(int i=3;i<num.length;i++){
            table[i]=Math.max(table[i-2],table[i-3])+num[i];
        }
        return Math.max(table[num.length-1],table[num.length-2]);
    
    }
}
