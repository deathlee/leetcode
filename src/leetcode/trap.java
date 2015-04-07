package leetcode;

public class trap {
	public static void main(String args[]) {
		trap trap=new trap();
		int A[]={4,2,0,3,2,4,3,4};
		trap.trap(A);
	}
    public int trap(int[] A) {
        if(A.length==0)return 0;
        int heightl=A[0];
        int heightr=A[A.length-1];
        int resultl=0;
        int resultr=0;
        int i=1;
        int j=A.length-2;
        while(i<=j){
            if(heightl<heightr){
            if(heightl>A[i]){
                resultl=resultl+heightl-A[i];
            }else{
                heightl=A[i];
            }
                i++;
            }else{
                
            if(heightr>A[j]){
                resultr=resultr+heightr-A[j];
            }else{
                heightr=A[j];
            }
            
                j--;
            }
        }
        return resultl+resultr;
    }

}
