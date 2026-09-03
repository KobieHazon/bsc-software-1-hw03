package il.ac.tau.cs.sw1.hw3;

import java.util.Arrays;

public class StringUtils {
    public static String findSortedSequence(String str) {
        String[] words = str.split(" " );
        String maxSequence = words[0];
        String currentSequence = words[0];
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < words.length; i++) {
            if (words[i].compareTo(words[i - 1]) >= 0) {
                currentSequence += " " + words[i];
                currentLength++;
            } else {
                currentSequence = words[i];
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxSequence = currentSequence;
                maxLength = currentLength;
            }
        }
        return maxSequence;
    }

    public static String parityXorStrings(String a, String b) {
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            String value = String.valueOf(a.charAt(i));
            if (result.contains(value) || (countOccurrences(a, value) % 2 == 0
                    && countOccurrences(b, value) % 2 == 1)) {
                result += value;
            }
        }
        return result;
    }

    public static boolean isAnagram(String a, String b) {
        char[] first = a.replaceAll(" ", "").toCharArray();
        char[] second = b.replaceAll(" ", "").toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    private static int countOccurrences(String text, String value) {
        return text.length() - text.replace(value, "").length();
    }
}
