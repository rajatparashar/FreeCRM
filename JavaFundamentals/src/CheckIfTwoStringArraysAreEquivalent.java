public class CheckIfTwoStringArraysAreEquivalent {

	public static void main(String[] args) {
		String[] word1 = { "abc", "d", "defg" };
		String[] word2 = { "abcddefg" };
		CheckIfTwoStringArraysAreEquivalent obj = new CheckIfTwoStringArraysAreEquivalent();
		System.out.println(obj.arrayStringsAreEqual(word1, word2));
	}

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		String one = "", two = "";
		for(int i=0;i<word1.length;i++) {
			one+= word1[i];
		}
		for(int i=0;i<word2.length;i++) {
			two+= word2[i];
		}
		return one.equals(two)?true:false;
	}
}