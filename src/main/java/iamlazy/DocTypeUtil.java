package iamlazy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DocTypeUtil {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Map<String, String>> in = new ArrayList<>();
		IntStream.range(0,20).forEach(index->{
			Map<String, String> map = new LinkedHashMap<>();
			map.put("value" , scanner.nextLine());
			map.put("destinationValue" , scanner.nextLine());
			in.add(map);
		});
		System.out.println("---- inputs are read ----");
		System.out.println("---- outputs are read-----");
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(in);

		System.out.println("------------------------");
		System.out.println(json);
	}
}
