package test;

public class maxProfit {
	public static void main(String args[]){
		int prices[]={2,1};
		maxProfit(prices);
	}

    public static int maxProfit(int[] prices) {
        if (prices.length==0)return 0;
        int min=Integer.MAX_VALUE;
        int max=0;
        int indexS=0;
        int indexP=0;
        for(int i=0;i<prices.length;i++){
        	if(max<prices[i]){
                
                max=prices[i];
                indexP=i;
            
            }
            if(min>prices[i]&&indexS<=indexP){
                min=prices[i];
                indexS=i;
            }
            
        }
        if((max-min)<0)
        {
            return 0;
        }else{
            return max-min;
        }
    }

}
