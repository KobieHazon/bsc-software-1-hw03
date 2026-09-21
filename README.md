# Software 1 - Homework 3

A 2018 CS BSc Java assignment submission implementing static array and string utility methods under `il.ac.tau.cs.sw1.hw3`. The implementation covers matrix transposition, cyclic array shifts, alternating sums, graph reachability, sorted word sequences, parity-style string comparison, and anagram checks.

## Implemented Methods

- `ArrayUtils.transposeMatrix(int[][])`: transposes a square matrix in place and returns it; non-square and empty matrices are returned unchanged.
- `ArrayUtils.shiftArrayCyclic(int[], int, char)`: cyclically shifts an array left or right in place.
- `ArrayUtils.alternateSum(int[])`: returns the maximum alternating sum over contiguous subarrays.
- `ArrayUtils.findPath(int[][], int, int)`: returns `1` when a directed path exists in an adjacency matrix and `0` otherwise.
- `StringUtils.findSortedSequence(String)`: returns the longest contiguous non-decreasing sequence of words.
- `StringUtils.parityXorStrings(String, String)`: preserves the parity-comparison behavior from the submitted source.
- `StringUtils.isAnagram(String, String)`: checks whether two strings are anagrams after removing spaces.

## Build

```bash
make
```

This compiles the Java sources into `build/` using `javac -Xlint:all -Werror`.

## Testing

```bash
make test
```

The regression harness exercises every public method.

## Repository Structure

- `src/il/ac/tau/cs/sw1/hw3/`: my Java implementation, maintained for current toolchains
- `tests/RunHw3Checks.java`: maintained Java regression harness
