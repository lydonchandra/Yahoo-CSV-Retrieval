package com.don.DataRetrieval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.MessageFormat;
import java.text.ParseException;

/**
 * Courtesy http://www.etraderzone.com/free-scripts/47-historical-quotes-yahoo.html 
 * http://ichart.finance.yahoo.com/table.csv - The default URL to download historical stock quotes, it won't work if you change the 'table.csv' to something else.
	s - This is where you can specify your stock quote, if you want to download stock quote for Microsoft, just enter it as 's=MSFT'
	a - This parameter is to get the input for the start month. '00' is for January, '01' is for February and so on.
	b - This parameter is to get the input for the start day, this one quite straight forward, '1' is for day one of the month, '2' is for second day of the month and so on.
	c - This parameter is to get the input for the start year
	d - This parameter is to get the input for end month, and again '00' is for January, '02' is for February and so on.
	e - This parameter is to get the input for the end day
	f - This parameter is to get the input for the end year
	g - This parameter is to specify the interval of the data you want to download. 'd' is for daily, 'w' is for weekly and 'm' is for monthly prices. The default is 'daily' if you ignore this parameter.
	With all the parameters above, you can now construct a URL to download historical prices for any stock quotes you want. But if you are going to download all historical prices for a stock quotes from day one onward (eg: Intel), you don't need to crack your head to look for information such as when is Intel went IPO. You just need to ignore the start and end date as follow:
	eg: http://ichart.finance.yahoo.com/table.csv?s=INTC
	If you only specify the start date and ignore the end date, it will download everything right from the start date until the most current prices.
	eg: http://ichart.finance.yahoo.com/table.csv?s=INTC&a=00&b=1&c=2000
 * 
 */
public class YahooData {
	
	// Yahoo URL
	public final static String YAHOO_URL = "http://table.finance.yahoo.com/table.csv?s={0}&a={1}&b={2}&c={3,number,#}" + "&d={4}&e={5}&f={6,number,#}&ignore=.csv&g={7}";
		
	public static BufferedReader getYahooData(String symbol,
									byte startDate, byte startMonth, short startYear, 
									byte endDate, byte endMonth, short endYear,
									String duration ) throws IOException, ParseException {
		
		// remember it's american date style mm/dd/yyyy
		String urlStr = MessageFormat.format(YAHOO_URL, symbol, startMonth, startDate, startYear, endMonth , endDate, endYear, duration);
		
		URL url = new URL(urlStr);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		
		return reader;
	}

}
