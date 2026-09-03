import il.ac.tau.cs.sw1.hw3.ArrayUtils;
import il.ac.tau.cs.sw1.hw3.StringUtils;

import java.util.Arrays;

public class RunHw3Checks {
    public static void main(String[] args) {
        testTransposeMatrix();
        testShiftArrayCyclic();
        testAlternateSum();
        testFindPath();
        testFindSortedSequence();
        testParityXorStrings();
        testIsAnagram();
        System.out.println("15 Java checks passed");
    }

    private static void testTransposeMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = ArrayUtils.transposeMatrix(matrix);
        assertMatrixEquals(new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, transposed, "transpose square");

        int[][] nonSquare = {{1, 2, 3}, {4, 5, 6}};
        int[][] returned = ArrayUtils.transposeMatrix(nonSquare);
        if (returned != nonSquare) {
            throw new AssertionError("non-square matrix should be returned unchanged");
        }
        assertMatrixEquals(new int[][] {{1, 2, 3}, {4, 5, 6}}, returned, "non-square unchanged");
    }

    private static void testShiftArrayCyclic() {
        int[] right = {1, 2, 3, 4, 5};
        assertArrayEquals(new int[] {4, 5, 1, 2, 3}, ArrayUtils.shiftArrayCyclic(right, 2, 'R'), "shift right");

        int[] left = {1, 2, 3, 4, 5};
        assertArrayEquals(new int[] {3, 4, 5, 1, 2}, ArrayUtils.shiftArrayCyclic(left, 2, 'L'), "shift left");

        int[] invalid = {1, 2, 3};
        assertArrayEquals(new int[] {1, 2, 3}, ArrayUtils.shiftArrayCyclic(invalid, 2, 'X'), "invalid direction");
    }

    private static void testAlternateSum() {
        assertEquals(4, ArrayUtils.alternateSum(new int[] {1, 2, 3, 4}), "simple alternate sum");
        assertEquals(11, ArrayUtils.alternateSum(new int[] {5, 1, 7}), "longer alternate sum");
        assertEquals(1, ArrayUtils.alternateSum(new int[] {-1, -2}), "negative alternate sum");
    }

    private static void testFindPath() {
        int[][] graph = {{0, 1, 0}, {0, 0, 1}, {0, 0, 0}};
        assertEquals(1, ArrayUtils.findPath(graph, 0, 2), "path through middle");
        assertEquals(0, ArrayUtils.findPath(graph, 2, 0), "no reverse path");
    }

    private static void testFindSortedSequence() {
        assertEquals("a b c", StringUtils.findSortedSequence("z a b c aa ab"), "longest sorted sequence");
        assertEquals("hello hello", StringUtils.findSortedSequence("hello hello apple"), "equal words are sorted");
    }

    private static void testParityXorStrings() {
        assertEquals("aa", StringUtils.parityXorStrings("aabc", "abb"), "recovered parity behavior");
        assertEquals("", StringUtils.parityXorStrings("abc", "z"), "no recovered parity match");
    }

    private static void testIsAnagram() {
        assertEquals(true, StringUtils.isAnagram("rail safety", "fairy tales"), "anagram with spaces");
        assertEquals(false, StringUtils.isAnagram("abc", "abd"), "non-anagram");
    }

    private static void assertEquals(boolean expected, boolean actual, String label) {
        if (expected != actual) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }

    private static void assertEquals(int expected, int actual, String label) {
        if (expected != actual) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }

    private static void assertEquals(String expected, String actual, String label) {
        if (!expected.equals(actual)) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }

    private static void assertArrayEquals(int[] expected, int[] actual, String label) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(label + " expected " + Arrays.toString(expected) + " but got " + Arrays.toString(actual));
        }
    }

    private static void assertMatrixEquals(int[][] expected, int[][] actual, String label) {
        if (!Arrays.deepEquals(expected, actual)) {
            throw new AssertionError(label + " expected " + Arrays.deepToString(expected) + " but got " + Arrays.deepToString(actual));
        }
    }
}
