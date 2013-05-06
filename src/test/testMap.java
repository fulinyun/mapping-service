package test;

import java.util.ArrayList;
import java.util.HashMap;

public class testMap {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> a = new HashMap<String, ArrayList<String>>();
		a.put("a", new ArrayList<String>());
		a.get("a").add("e");
		for (String i : a.get("a")) System.out.println(i);
	}
}
