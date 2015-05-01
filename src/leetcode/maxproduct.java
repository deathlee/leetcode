package leetcode;

public class maxproduct {
	public static void main(String args[]) {
		maxproduct maxproduct=new maxproduct();
		int A[]={-3,-4,-2};
		maxproduct.maxProduct(A);
	}
    public int maxProduct(int[] A) {
        if(A.length==1)return A[0];
        int max=Integer.MIN_VALUE;
        int maxproduct=1;
        int minproduct=1;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                if(A[i]>max)
                {
                    max=A[i];
                }
                maxproduct=1;
                minproduct=1;
            }else{
            	int tmp=maxproduct;
                maxproduct=Math.max(Math.max(maxproduct*A[i],minproduct*A[i]),A[i]);
                minproduct=Math.min(Math.min(tmp*A[i],minproduct*A[i]),A[i]);
                if(maxproduct>max){
                    max=maxproduct;
                }
            }
        }
        return max;
    }

}
