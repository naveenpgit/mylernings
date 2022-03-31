package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestLinkedIN {

	public static void main(String[] args) {
		double val = 77.48;
		BigDecimal _1 = new BigDecimal(val);
		BigDecimal _2 = BigDecimal.valueOf(val);
		BigDecimal _3 = new BigDecimal(77.48);
		System.out.println(_1.equals(_2));
		System.out.println(_1.equals(_3));
		System.out.println(_2.equals(_3));
		System.out.println(BigDecimal.valueOf(1000).compareTo(BigDecimal.valueOf(1000.00)));

		BigInteger bi = BigInteger.valueOf(new Integer(7));

		List<String> li = new ArrayList<>();

		System.out.println(Math.round(22.9));
		Set<Integer> set = new TreeSet<>();
		set.add(3);
		set.add((int) 3.0);
		set.add(2);
		set.add(2);
		set.add(new Integer(2));
		set.add(Integer.parseInt("2"));
		System.out.println(set);

		Collection<String> collection = new ArrayDeque<>();
		collection.add("foo");
		collection.add("bar");
		collection.add("baz");
		collection.forEach(System.out::println);
	}

}
