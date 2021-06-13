public class ShuffleTheArray {

	public static void main(String[] args) {
		int nums[] = { 2, 5, 1, 3, 4, 7 };
		int n = 3;
		new ShuffleTheArray().shuffle(nums, n);
	}

	public int[] shuffle(int[] nums, int n) {
		int a[] = new int[2 * n];
		int b[] = new int[2 * n];
		int c[] = new int[2 * n];
		for (int i = 0; i < n; i++) {
			a[2 * i] = nums[i];
		}
		for (int i = n; i < nums.length; i++) {
			b[2 * (i - n) + 1] = nums[i];
		}
		for (int i = 0; i < 2 * n; i++) {
			c[i] = a[i] | b[i];
		}
		return c;
	}
}