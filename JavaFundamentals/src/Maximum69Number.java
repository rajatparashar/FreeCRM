public class Maximum69Number {
	public static void main(String[] args) {
		Maximum69Number obj = new Maximum69Number();
		int num = 99999;
		System.out.println(obj.maximum69Number(num));
	}

	public int maximum69Number(int num) {
		StringBuilder sb = new StringBuilder(Integer.toString(num));
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '6') {
				sb.replace(i, i + 1, "9");
				break;
			}
		}
		return Integer.parseInt(sb.toString());
	}
}