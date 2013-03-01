package com.awole20.test;

import java.io.File;
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
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.SyndFeedOutput;
import com.sun.syndication.io.XmlReader;

public class RomeTest {

	private SyndFeed feed;
	private String path;
	List<SyndEntry> entries;
	
	public RomeTest(String path) throws IllegalArgumentException, FeedException, IOException {
		
		this.path = path;
		File feedSource = new File(path);
		if (feedSource.exists()) {
			SyndFeedInput input = new SyndFeedInput();
			feed = input.build(new XmlReader(feedSource));
		} else {
			feed = new SyndFeedImpl();
			feed.setFeedType("atom_0.3");
			feed.setTitle("MyProject Build Results");
			feed.setLink("http://myproject.mycompany.com/continuum");
			feed.setDescription("Continuous build results for the MyProject project");
		}
		entries = feed.getEntries();
		if (entries == null) {
			entries = new ArrayList<SyndEntry>();
		}
	}
	
	public void addEntry(String title, String content) {
		SyndEntry entry = new SyndEntryImpl();
		entry.setTitle(title);
		entry.setLink("http://myproject.mycompany.com/continuum/build-results-1?" + entries.size());
		entry.setPublishedDate(new Date());
		
		SyndContent description = new SyndContentImpl();
		description.setType("text/html");
		description.setValue(content);
		entry.setDescription(description);
		
		entries.add(entry);
		feed.setEntries(entries);
	}
	
	public void publish() throws IOException, FeedException {
		Writer writer = new FileWriter(path);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed,writer); writer.close();
	}
	
}
