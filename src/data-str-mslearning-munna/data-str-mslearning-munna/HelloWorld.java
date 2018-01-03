
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {

	/**
	 * prints tags found in "code"
	 */
	public static void printTags(String code) {

		// fix this Pattern:
		Pattern pattern = Pattern.compile(".*");
		Matcher m = pattern.matcher(code);

		StringBuffer buf = new StringBuffer();
		// print all the tags that were found
		while (m.find()) {
			System.out.println("tag: " + m.group(1));
		}
	}
	public static void main(String[] args) {
		printTags("<html><body><a href=\"http://www.com\">");
	}

}
