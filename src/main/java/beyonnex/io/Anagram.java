package beyonnex.io;

import java.util.Arrays;

/**
 * @author ravisha.gaur
 */
public class Anagram {

	/**
	 * The method checkIfTextsAreAnagrams check if texts are anagrams of each other
	 * <p>There should be at least two texts to check anagrams. If there is only one, false is returned.
	 * Then, length of the two string are checked after removing special characters from both the texts. If the lengths do not match, the texts cannot be anagrams of each other and
	 * false is returned without performing any other checks.
	 * If the lengths are the same, then the two texts are converted to the same case, sorted alphabetically and checked if both are equal. If not, return false and no need to check for other texts
	 * If yes, then check for other texts, repeating the logic for all texts.
	 * </p>
	 *
	 * @param text1 the first text we want to check is anagram of another text
	 * @param text2 the other text(s) we want to check is anagram of given text
	 * @return isAnagram true if all given texts are anagrams, false otherwise
	 */
	public boolean checkIfTextsAreAnagrams(String text1, String... text2) {

		boolean isAnagram = false;
		String text1WithoutSpecialCharacters = replaceSpecialCharacters(text1);
		for (int i = 0; i < text2.length; i++) {
			String text2WithoutSpecialCharacters = replaceSpecialCharacters(text2[i]);

			// if lengths do not match after replacing special characters, the texts cannot be anagrams of each other
			if (text1WithoutSpecialCharacters.length() == text2WithoutSpecialCharacters.length()) {
				isAnagram = checkAnagram(text1WithoutSpecialCharacters, text2WithoutSpecialCharacters);
				if(!isAnagram)
					return false;
			}
			else
				return false;
		}
		return isAnagram; //at least two texts are needed
	}


	/**
	 * The method checkAnagram contains the logic to check for anagrams
	 * @param text1 the first text we want to check is anagram of another text
	 * @param text2 the other text(s) we want to check is anagram of given text
	 * @return result true if all given texts are anagrams, false otherwise
	 */
	private boolean checkAnagram(String text1, String text2) {
		// set both texts to same case (here lower case)
		char[] text1CharArray = text1.toLowerCase().toCharArray();
		char[] text2CharArray = text2.toLowerCase().toCharArray();

		// sort both char arrays alphabetically
		Arrays.sort(text1CharArray);
		Arrays.sort(text2CharArray);

		// compare the sorted char arrays

		return Arrays.equals(text1CharArray, text2CharArray);
	}

	/**
	 * The method replaceSpecialCharacters replaces all occurrences of all special characters from the texts we want to check are anagrams of each other
	 * @param textForAnagram The text we want to remove all special characetrs from
	 * @return textForAnagram The text with no special characters
	 */
	private String replaceSpecialCharacters(String textForAnagram) {

		/* as per wikipedia anagram definition, special characters like spaces, hyphen, quotes are not considered a part of the text when checking for anagrams:
		 https://en.wikipedia.org/wiki/Anagram */
		textForAnagram = textForAnagram.replaceAll("\\s+", "").replace(";", "").replace(",", "").replace("-", "").replace("\'", "")
				.replace("\"", ""); //can be extended to add more characters as needed
		return textForAnagram;
	}
}
