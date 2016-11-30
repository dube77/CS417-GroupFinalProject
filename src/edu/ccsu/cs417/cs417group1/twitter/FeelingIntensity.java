package edu.ccsu.cs417.cs417group1.twitter;

public enum FeelingIntensity {

	//not very, somewhat, blank, quite, very
	ONE("not very"),
	TWO("somewhat"),
	THREE(""),
	FOUR("quite"),
	FIVE("very");
	
	private final String description;
	
	private FeelingIntensity(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
