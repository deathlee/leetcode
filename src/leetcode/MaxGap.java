package leetcode;

public class MaxGap {
	public static void main(String args[]) {
		MaxGap maxGap=new MaxGap();
		int []num={100,3,2,1};
		maxGap.maximumGap(num);
	}
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
        return 0;
    // get the max and min value of the array
    int min = num[0];
    int max = num[0];
    for (int i:num) {
        min = Math.min(min, i);
        max = Math.max(max, i);
    }
    int gap= (int)Math.ceil((double)(max-min)/(num.length-1));
    int maxNum[]=new int[num.length];
    int minNum[]=new int[num.length];
    for (int i:num) {
        int idx=(int)Math.ceil((double)(i-min)/gap);
        if(i>maxNum[idx]){
            maxNum[idx]=i;
        }
        if(i<minNum[idx]||minNum[idx]==0){
            minNum[idx]=i;
        }
    }
    int maxGap=0;
    int previousMax=maxNum[0];
    for(int i=1;i<num.length;i++){
    	if(maxNum[i]==0){
    		continue;
    	}
        if(minNum[i]-previousMax>maxGap){
            maxGap=minNum[i]-previousMax;
        }
        previousMax=maxNum[i];
    }
    return maxGap;
    }

}
