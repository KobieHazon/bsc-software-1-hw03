package il.ac.tau.cs.sw1.hw3;

public class ArrayUtils {
    public static int[][] transposeMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0].length != matrix.length) {
            return matrix;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = row; column < matrix[row].length; column++) {
                int value = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = value;
            }
        }
        return matrix;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (move <= 0 || array.length == 0 || (direction != 'R' && direction != 'L')) {
            return array;
        }

        int normalizedMove = move % array.length;
        int sourceOffset = direction == 'R' ? normalizedMove : array.length - normalizedMove;
        int[] original = array.clone();
        for (int offset = 0; offset < original.length; offset++) {
            int destination = (sourceOffset + offset) % original.length;
            array[destination] = original[offset];
        }
        return array;
    }

    public static int alternateSum(int[] array) {
        int max = 0;
        for (int start = 0; start < array.length; start++) {
            int sum = 0;
            int sign = 1;
            for (int end = start; end < array.length; end++) {
                sum += sign * array[end];
                max = Math.max(max, sum);
                sign *= -1;
            }
        }
        return max;
    }

    public static int findPath(int[][] matrix, int source, int target) {
        boolean[] visited = new boolean[matrix.length];
        return pathRec(matrix, source, target, visited);
    }

    private static int pathRec(int[][] matrix, int source, int target, boolean[] visited) {
        visited[source] = true;
        if (matrix[source][target] == 1) {
            return 1;
        }

        for (int candidate = 0; candidate < matrix[source].length; candidate++) {
            if (!visited[candidate] && matrix[source][candidate] == 1
                    && pathRec(matrix, candidate, target, visited) == 1) {
                return 1;
            }
        }
        return 0;
    }
}
