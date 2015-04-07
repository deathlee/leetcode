package leetcode;

public class firstMissingPositive {

    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++){
            int tmp=A[i];
            while(tmp-1>=0&&tmp-1<A.length&&A[tmp-1]!=tmp){
                int tmp1=A[i];
                A[i]=A[tmp-1];
                A[tmp1-1]=A[i];
                tmp=A[i];
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]-1!=i){
                return i+1;
            }
        }
        return A.length+1;
    }

}
