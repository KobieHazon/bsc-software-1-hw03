package il.ac.tau.cs.sw1.hw3;

public class ArrayUtils {
	
	public static int[][] transposeMatrix(int[][] m)
	{
		if (m.length == 0 || m[0].length == 0 || m[0].length != m.length) {
			return m;
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = i; j < m[0].length; j++) {
				int tmp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = tmp;
			}
		}
		return m;
		
	}
	
	public static int[] shiftArrayCyclic(int[] array, int move, char direction)
	{
		if (move <= 0 || (direction != 'R' && direction != 'L') || array.length == 0) {
			return array;
		}
		move %= array.length;
		int startPos = direction == 'R' ? move : array.length-move;
		int[] tmp = array.clone();
		for (int i = startPos; i < startPos + array.length; i++) {
			array[i >= array.length ? i-array.length:i] = tmp[i-startPos];
		}
		return array;
	}
	
	public static int alternateSum(int[] array)
	{
		int max = 0;
		int sum;
		for (int startPos = 0; startPos < array.length; startPos++) {
			sum = 0;
			for (int endPos = startPos; endPos < array.length; endPos++) {
				sum += Math.pow(-1, endPos-startPos)*array[endPos];
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	public static int findPath(int[][] m, int i, int j)
	{
		boolean[] visited = new boolean[m.length];
		for (int k = 0; k < m.length; k++) {
			visited[k] = false;
		}
		return path_Rec(m, i, j, visited);
	}
	
	private static int path_Rec(int[][] m, int i, int j, boolean[] visited) {
		visited[i] = true;
		if (m[i][j] == 1) {
			return 1;
		}
		for (int otherNodes = 0; otherNodes < m[i].length; otherNodes++) {
			if (visited[otherNodes] != true  && m[i][otherNodes] == 1 && path_Rec(m, otherNodes, j, visited) == 1) {
				return 1;
			}
		}
		return 0;
	}

}
