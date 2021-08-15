public class Jpmc {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println(c.getMiles());
	}

	static class Car {
		Integer miles;

		Car() {
			miles++;
		}

		public int getMiles() {
			return miles;
		}
	}
}
