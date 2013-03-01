package com.awole20.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;

import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class RomeTest {

	private SyndFeed feed;
	List<SyndEntry> entries = new ArrayList<SyndEntry>();
	
	public RomeTest() {
		feed = new SyndFeedImpl();
		feed.setFeedType("rss_1.0");
		feed.setTitle("MyProject Build Results");
		feed.setLink("http://myproject.mycompany.com/continuum");
		feed.setDescription("Continuous build results for the MyProject project");
	}
	
	public void addEntry(String title, String content) {
		SyndEntry entry = new SyndEntryImpl();
		entry.setTitle(title);
		entry.setLink("http://myproject.mycompany.com/continuum/build-results-1?" + title);
		entry.setPublishedDate(new Date());
		
		SyndContent description = new SyndContentImpl();
		description.setType("text/html");
		description.setValue(content);
		entry.setDescription(description);
		
		entries.add(entry);
		feed.setEntries(entries);
	}
	
	public void publish(String path) throws IOException, FeedException {
		Writer writer = new FileWriter(path);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed,writer); writer.close();
	}
	
}
