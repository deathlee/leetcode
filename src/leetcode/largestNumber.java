package leetcode;

public class largestNumber {

	public static void main(String args[]){
		int num[]={12,121};
		largestNumber(num);
		System.out.println("CNM");
	}
    public static String largestNumber(int[] num) {
        int begin=0;
        int end=num.length-1;
        int temp[] = new int[num.length];
        mergeSort(num,temp,begin,end);
        StringBuilder result=new StringBuilder("");
        for(int i=0;i<num.length;i++){
            result.append(num[num.length-1-i]);
        }
        return result.toString();
    }
    static void mergeSort(int num[],int temp[],int begin,int end){
        if(begin==end){
            return;
        }
        int mid=(begin+end)/2;
        mergeSort(num,temp,begin,mid);
        mergeSort(num,temp,mid+1,end);
        for(int i=0;i<temp.length;i++){
            temp[i]=num[i];
        }
        int index1=begin;
        int index2=mid+1;
        int index=begin;
        while(index1<mid+1&&index2<end+1){
            if(numABiggerNumB((double)temp[index1],(double)temp[index2])){
                num[index++]=temp[index2++];
            }else{
                num[index++]=temp[index1++];
            }
        }
        while(index1<mid+1){
            num[index++]=temp[index1++];
        }
         while(index2<end+1){
            num[index++]=temp[index2++];
        }
        
    }
    static boolean numABiggerNumB(double A,double B){
        int lengthA = String.valueOf(A).length();
        int lengthB = String.valueOf(B).length();
        if(lengthA>lengthB){
            B=B*Math.pow(10,(double)(lengthA-lengthB));
        }else{
            A=A*Math.pow(10,(double)(lengthB-lengthA));
        }
        if(A>B)return true;
        else if(A==B&&lengthA<lengthB)return true;
        else if(A==B&&lengthA>lengthB)return false;
        else return false;
    }


}
