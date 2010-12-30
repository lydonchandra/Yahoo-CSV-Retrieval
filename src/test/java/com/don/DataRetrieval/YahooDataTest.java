package com.don.DataRetrieval;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;

public class YahooDataTest 
{
	@org.junit.Test
    public void testGetYahooData() throws IOException, ParseException
    {	
		// retrieve GLD price for 1st and 2nd January 2010
		BufferedReader reader = YahooData.getYahooData("GLD", (byte)1, (byte)1, (short)2010, (byte)2, (byte)1, (short)2010, "d");
		String header = reader.readLine();
		String firstRow = reader.readLine();
		String secondRow = reader.readLine();
		String thirdRow = reader.readLine();
		
		// assert we have only 3 rows which are
		//Date,Open,High,Low,Close,Volume,Adj Close
		//2010-02-02,109.16,109.60,108.61,109.13,14292200,109.13
		//2010-02-01,106.64,108.48,106.37,108.35,14901900,108.35
		Assert.assertTrue(header.length() > 0);
		Assert.assertTrue(firstRow.length() > 0);
		Assert.assertTrue(firstRow.contains("2010-02-02,109.16,109.60,108.61,109.13,14292200,109.13"));
		Assert.assertTrue(secondRow.length() > 0);
		Assert.assertTrue(secondRow.contains("2010-02-01,106.64,108.48,106.37,108.35,14901900,108.35"));
		Assert.assertNull(thirdRow);
    }
}
