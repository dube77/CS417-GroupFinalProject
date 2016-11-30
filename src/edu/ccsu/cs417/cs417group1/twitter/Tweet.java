package edu.ccsu.cs417.cs417group1.twitter;

import edu.ccsu.cs417.cs417group1.twitter.Tweet.TweetBuilder;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Tweet {

	private final String vision;
	private final String feeling;
	private final FeelingIntensity intensity;

	private Tweet(TweetBuilder builder) {
		this.vision = builder.vision;
		this.feeling = builder.feeling;
		this.intensity = builder.intensity;
	}
	
	public void PublishTweet() throws TwitterException{
		Twitter twitter = TwitterFactory.getSingleton();
		String newTweet = "I see a " + vision + " and it makes me feel " + intensity.toString() + " " + feeling;
		Status status = twitter.updateStatus(newTweet);
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
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
			if ((vision != null) && (feeling != null) && (intensity != null)) {
				return true;
			} 
			else {
				return false;
			}
		}

		public TweetBuilder setFeelingIntensity(FeelingIntensity intensity) {
			this.intensity = intensity;
			return this;
		}

	}
}