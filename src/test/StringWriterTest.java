package test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriterTest {

	public static void main(String[] args) {
		System.out.println(getString());
	}
	
	public static String getString() {
		StringWriter sw  = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.println("line 1: hello");
		pw.println("line 2: world");
		pw.close();
		return sw.toString();
	}
}
