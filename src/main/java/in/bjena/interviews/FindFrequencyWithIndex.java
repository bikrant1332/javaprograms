package in.bjena.interviews;

import java.util.HashMap;

public class FindFrequencyWithIndex {
	public static void main(String[] args) {
		String[] a = { "3", "6", "5", "3", "6", "6" };
		HashMap<String, String> map = new HashMap<String, String>();
		String temp = "";
		for (int i = 0; i < a.length; i++) {
			temp = "";
			if (map.containsKey(a[i])) {
				String[] values = map.get(a[i]).split("_");
				values[1] = String.valueOf(Integer.valueOf(values[1]) + 1);
				values[values.length - 1] = values[values.length - 1] + "_" + i;
				for (String c : values) {
					temp += c + "_";
				}
				map.put(a[i], temp);
			} else {
				temp = "count_" + 1 + "_index_" + i;
				map.put(a[i], temp);
			}

		}
		// map.forEach((k,v)->System.out.println("key : "+k+" value : "+v));
		map.forEach((k, v) -> {
			String[] values = v.split("_");
			if (Integer.parseInt(values[1]) > 1) {
				System.out.println("key : " + k + " value : " + v);
			}
		});
	}
}
