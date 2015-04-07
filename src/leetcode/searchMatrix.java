package leetcode;

public class searchMatrix {
	public static void main(String args[]) {
		int [][]matrix={{1,3,5}};
		int target=0;
		searchMatrix searchMatrix=new searchMatrix();
		System.out.println(searchMatrix.searchMatrix(matrix,target));
	}
    public boolean searchMatrix(int[][] matrix, int target) {
    	int row=matrix.length;
    	int col=matrix[0].length;
        int start=0;
        int end=row*col-1;
        int mid=(start+end)/2;
        while(start<=end){
            if(matrix[mid/col][mid%(col)]>target){
            	end=mid-1;
            	mid=(start+end)/2;
            }else if(matrix[mid/col][mid%(col)]==target){
                return true;
            }else{
            	start=mid+1;
            	mid=(start+end)/2;
            }
        }
        return false;
    }

}
