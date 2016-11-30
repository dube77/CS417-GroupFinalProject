package edu.ccsu.cs417.cs417group1.twitter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.Tweet.TweetBuilder;

public class TweetTest {

	Tweet tweet;
	Tweet.TweetBuilder builder;
	private String vision = "vision";
	private String feeling = "feeling";
	FeelingIntensity intensity;
	
	@Before 
	public void setup() {
		builder = new TweetBuilder(vision, feeling);
	}
	
	@Test
	public void builderCompleteTest() {
		assertTrue(builder.builderComplete());
		
		builder = new TweetBuilder(null, feeling);
		assertFalse(builder.builderComplete());
		builder = new TweetBuilder(vision, null);
		assertFalse(builder.builderComplete());
		builder = new TweetBuilder(null, null);
		assertFalse(builder.builderComplete());
	}
	
	@Test
	public void buildTweetTest() {
		assertNotNull(builder.buildTweet());
	}
	
	@Test (expected=RuntimeException.class)
	public void buildEsceptionTest()  {
		builder = new TweetBuilder(null, null);
		assertNotNull(builder.buildTweet());
	}
	
	@Test
	public void setIntensityTest() {
		assertNotNull(builder.setFeelingIntensity(intensity));
	}

}
