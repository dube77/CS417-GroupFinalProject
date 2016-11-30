package edu.ccsu.cs417.cs417group1.twitter;

import edu.ccsu.cs417.cs417group1.twitter.Tweet.TweetBuilder;

public class Tweet {

	private final String vision;
	private final String feeling;
	private final FeelingIntensity intensity;

	private Tweet(TweetBuilder builder) {
		this.vision = builder.vision;
		this.feeling = builder.feeling;
		this.intensity = builder.intensity;
	}

	public static class TweetBuilder {
		private String vision = null;
		private String feeling = null;
		private FeelingIntensity intensity = null;

		public TweetBuilder(String vision, String feeling) {
			this.vision = vision;
			this.feeling = feeling;
		}

		public Tweet buildTweet() {
			if (!builderComplete()) {
				throw new RuntimeException("Not full Tweet");
			}
			return new Tweet(this);
		}

		public boolean builderComplete() {
			if ((vision != null) && (feeling != null)) {
				return true;
			} else {
				return false;
			}
		}

		public TweetBuilder setFeelingIntensity(FeelingIntensity intensity) {
			this.intensity = intensity;
			return this;
		}

	}
}