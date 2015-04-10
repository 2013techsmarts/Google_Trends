package org.smarttechie.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.smarttechie.model.GoogleTrendItem;
import org.springframework.batch.item.ItemWriter;

/**
 * The writer to write the list of google trends
 * @author Siva Janapati
 * @version 1.0
 *
 */
public class GoogleTrendsWriter implements ItemWriter<List<GoogleTrendItem>>{

	private Log log = LogFactory.getLog(GoogleTrendsWriter.class);

	@Override
	public void write(List<? extends List<GoogleTrendItem>> trends)
			throws Exception {
		if (trends != null && !trends.isEmpty()) {
			List<GoogleTrendItem> items = trends.get(0);
			if (items != null && !items.isEmpty()) {
				for (GoogleTrendItem trend : items) {
					log.debug("Title: " + trend.getTitle());
					log.debug("Link: " + trend.getLink());
					log.debug("Plain text description: " + trend.getDescription());
				}
			}
		}

	}

}
