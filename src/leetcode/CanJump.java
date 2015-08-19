package leetcode;

public class CanJump {
public static void main(String args[]) {
	CanJump canJump=new CanJump();
	int []nums={1,0,2};
	canJump.canJump(nums);
}

public boolean canJump(int[] nums) {
    int positions=0;
    while(true){
        int maxJump=0;
        int idx=0;
        for(int j=positions;j<Math.min(positions+nums[positions]+1,nums.length);j++){
            if(j+nums[j]>=maxJump){
                maxJump=j+nums[j];
                idx=j;
            }
        }
        positions=idx;
        if(maxJump>=nums.length-1){
            return true;
        }else if(nums[positions]==0){
            return false;
        }
    }
}

}

