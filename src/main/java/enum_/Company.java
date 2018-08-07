package enum_;

public enum Company{
	A("India") , B("US"), C("UK"), D("Singapore");

	private final String country;

	Company(String country) {
		this.country = country;
	}

	public String getCountry() {
		return "C__" + country;
	}
}
