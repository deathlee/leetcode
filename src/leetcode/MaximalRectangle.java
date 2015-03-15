package leetcode;

public class MaximalRectangle {

	public static void main(String args[]) {
		char[][] matrix = { { '1','1','0','1' },{'1','1','0','1'},{'1','1','1','1'} };
		int result = maximalRectangle(matrix);
		System.out.println(result);
	}

	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (visited[i][j] == false && matrix[i][j] == '1') {
					int result=checkRe(visited, matrix, i, j);
					if ( result> max) {
						max = result;
					}
				}
			}
		}
		return max;

	}

	static int checkRe(boolean visited[][], char matrix[][], int i, int j) {
		int maxArea = 0;
		int area[] = new int[matrix.length];
		int lastCol = 0;
		for (int m = i; m < matrix.length; m++) {
			int col = 0;
			for (int n = j; n < matrix[0].length; n++) {
				if (matrix[m][n] == '1') {
					visited[m][n] = true;
					col++;
				} else {
					break;

				}
			}
			
			if (m == 0) {
				area[m] = col;
				lastCol = col;
				continue;
			}
			if (col > lastCol) {
				if (col > (area[m - 1] + lastCol)) {
					area[m] = col;
				} else {
					area[m] = area[m - 1] + lastCol;
				}
			} else {
				area[m] = area[m - 1] - (lastCol - col) * (m - j) + col;
			}
			lastCol = col;
			if (col == 0)
				break;
		}
		int max = 0;
		for (int k = 0; k < matrix.length; k++) {

			if (area[k] > max) {
				max=area[k];
			}
		}
		return max;
	}

}
