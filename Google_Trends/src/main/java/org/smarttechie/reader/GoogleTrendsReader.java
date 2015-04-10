package org.smarttechie.reader;

import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.smarttechie.model.GoogleTrendItem;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * The reader gets the atom feed and parses it.
 * @author Siva Janapati
 * @version 1.0
 *
 */
public class GoogleTrendsReader implements ItemReader<List<GoogleTrendItem>>{

	private Log log = LogFactory.getLog(GoogleTrendsReader.class);
	
	/**
	 * The reader will make call to google hot trends API
	 */
	@Override
	public List<GoogleTrendItem> read() throws Exception, UnexpectedInputException,
	ParseException, NonTransientResourceException {
		URL url = new URL("http://www.google.com/trends/hottrends/atom/feed?pn=p3");

		Feed feed = FeedParser.parse(url);

		int items = feed.getItemCount();
		log.debug("The number of hot trends " + items);
		List<GoogleTrendItem> trends = null;
		if (items > 0) {
			trends = new ArrayList<GoogleTrendItem>();
			for (int i = 0; i < items; i++) {
				FeedItem item = feed.getItem(i);
				GoogleTrendItem trend = new GoogleTrendItem();
				trend.setTitle(item.getTitle());
				trend.setLink(item.getLink().toString());
				trend.setDescription(item.getDescriptionAsText());
				trends.add(trend);
			}
		}
		return trends;
	}

}
