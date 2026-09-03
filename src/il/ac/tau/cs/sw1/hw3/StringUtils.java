package il.ac.tau.cs.sw1.hw3;

public class StringUtils {
	
	public static String findSortedSequence(String str)
	{
		String[] words = str.split(" ");
		String maxSeq = words[0];
		String currentSeq = words[0];
		for (int i = 1; i < words.length; i++) {
			if (words[i].compareTo(words[i-1]) >= 0) {
				currentSeq += " " + words[i];
			}
			else {
				currentSeq = words[i];
			}
			if (currentSeq.split(" ").length > maxSeq.split(" ").length) {
				maxSeq = currentSeq;
			}
		}
		return maxSeq;
	}

	public static String parityXorStrings(String a, String b)
	{
		String res = "";
		String tmp;
		for (int i = 0; i < a.length(); i++) {
			tmp = String.valueOf(a.charAt(i));
			if (res.contains(tmp) == true || ((a.length() - a.replace(tmp, "").length()) % 2 == 0 && (b.length() - b.replace(tmp, "").length()) % 2 == 1))  {
				res += tmp;
			}
		}
		return res;
	}
	
	public static boolean isAnagram(String a, String b)
	{
		char[] array1 = a.replaceAll(" ", "").toCharArray();
		char[] array2 = b.replaceAll(" ", "").toCharArray();
		java.util.Arrays.sort(array1);
		java.util.Arrays.sort(array2);
		return java.util.Arrays.equals(array1, array2) ? true : false;
		
	}
}
