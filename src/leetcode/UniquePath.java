package leetcode;

public class UniquePath {
	public static void main(String args[]) {
		System.out.println(uniquePaths(4, 4));
	}
    public static int uniquePaths(int m, int n) {
        int N=m+n-2;
        int k=m-1;
        long res=1;
        for (int i = 1; i <= k; i++)
        {
            res = res * (N - k + i) / i;
            System.out.println((N - k + i) / i);
        }
            return (int)res;
        
    }
}
