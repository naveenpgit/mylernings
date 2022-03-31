package leetcode;

public enum Direction {
	EAST("E"),
	WEST("W"),
	NORTH("N"),
	SOUTH("S");

	private final String shortCode;

	Direction(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getShortCode() {
		return shortCode;
	}
}
