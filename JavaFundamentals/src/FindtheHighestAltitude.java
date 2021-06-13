public class FindtheHighestAltitude {
	public static void main(String[] args) {
		FindtheHighestAltitude obj = new FindtheHighestAltitude();
		int[] gain = { -5, 1, 5, 0, -7 };
		System.out.println(obj.largestAltitude(gain));
	}

	public int largestAltitude(int[] gain) {
		int[] altitudes = new int[gain.length];
		altitudes[0] = 0;
		int height = 0;
		for (int i = 1; i < gain.length; i++) {
			height += gain[i - 1];
			altitudes[i] = height;
		}

		for (int i = 0; i < altitudes.length; i++) {
			System.out.print(altitudes[i] + " ");
		}
		return 0;
	}
}