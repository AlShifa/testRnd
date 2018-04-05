public class StringWrapper {

	private String string;
	private int hash;

	public StringWrapper(String s) {
		init(s);
	}

	public void recycle(String newStr) {
		init(newStr);
	}

	public void init(String s) {
		string = s;

		int len = string.length();
		int c0 = string.charAt(0);
		int cn = string.charAt(len - 1);

		hash = len * (31 * c0 + cn);
	}

	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if ((anObject != null) && (anObject instanceof StringWrapper)) {
			StringWrapper p = (StringWrapper) anObject;
			return string.equals(p.getString());
		}

		return false;
	}

	public int hashCode() {
		return hash;
	}

	public String getString() {
		return string;
	}

}
