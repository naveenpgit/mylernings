package enum_;

public enum Team  {
	A("India"), B("US"), C("UK"), D("Singapore");

	private final String country;

	Team(String country) {
		this.country = country;
	}

	public String getCountry() {
		return "T__" + country;
	}
}
