package leetcode;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber happyNumber=new HappyNumber();
		happyNumber.isHappy(7);
	}

    public boolean isHappy(int n) {
        HashSet<Integer> record=new HashSet<Integer>();
        record.add(n);
        while(true){
            int num=0;
            while(n!=0){
                int tmp=n%10;
                num+=(tmp*tmp);
                n=n/10;
            }
            if(num==1)return true;
            if(!record.contains(num)){
                record.add(num);
                n=num;
            }else{
                return false;
            }
        }
        
    }

}
