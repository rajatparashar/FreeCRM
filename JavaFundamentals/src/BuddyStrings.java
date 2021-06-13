public class BuddyStrings {

	public static void main(String[] args) {
		String a = "ab";
		String b = "ba";

		System.out.println(new BuddyStrings().buddyStrings(a, b));
	}

	public boolean buddyStrings(String a, String b) {
		if (a.equals(b)) {
			return true;
		} else if (a.length() != b.length()) {
			return false;
		} else {
			int sum = 0;
			for (int i = 0; i < a.length(); i++) {
				sum += (a.charAt(i)|b.charAt(i))==1?0:1;
			}
			System.out.println(sum);
			return false;
		}
	}
}