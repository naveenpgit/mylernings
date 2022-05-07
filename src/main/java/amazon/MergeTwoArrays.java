package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MergeTwoArrays {
	public static void main(String[] args) {
		Object[] res = merge(
				new Object[] {new Integer(1),new Integer(4),new Integer(10),new Integer(4)},
				new Object[] {new Integer(2),new Integer(3),new Integer(4),new Integer(30),new Integer(1)}
		);

		Arrays.stream(res).forEach(System.out::println);

		 res = merge(
				new Object[] {new Employee(1, "Adam"),new Employee(2, "Paul"), new Employee(1, "Adam")},
				new Object[] {new Employee(3, "Merry"),new Employee(2, "Adam"),new Employee(4, "Paul") }
		);

		Arrays.stream(res).forEach(System.out::println);
	}

	static Object[] merge(Object[] a, Object[] b){
		final Set<Object> mergedData = new LinkedHashSet<>();
		Arrays.stream(a).forEach(x-> mergedData.add(x) );
		Arrays.stream(b).forEach(x-> mergedData.add(x) );

		return (new ArrayList<Object>(mergedData)).toArray();
	}

	static class Employee {

		private String name;
		private Integer employeeId;

		public  Employee(Integer employeeId,String name ){
			this.employeeId = employeeId;
			this.name = name;
		}

		@Override
		public boolean equals(Object e){
			Employee incoming = (Employee)e;
			return  incoming.name.equals(this.name) && incoming.employeeId.equals(this.employeeId);
		}

		@Override
		public int hashCode(){
			return this.employeeId.hashCode() + this.name.hashCode();
		}

		@Override
		public String toString(){
			return this.employeeId + " -- " + this.name;
		}
	}
}
