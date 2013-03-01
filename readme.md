# Java Rss Feed reader, ROME Hello World Example

This is a simple hello world for a java web app using [rome](https://rometools.jira.com). This publishes bogus stories when the url at /PublishRss is hit, and the stories are written to /rss.

#### Notes
* ROME is dependent on jdom1.x
* RSS readers (at least 1.0) seem to be link-dependent. Any links that have already been synthesized are seen as "old news".
* There doesn't seem to be any documentation as to what valid feed types are. The [example](http://www.javaworld.com/javaworld/jw-11-2007/jw-11-rome.html?page=2) I found used "rss_1.0".
* This example reads in the existing rss file, and appends.

#### TODO
* Find more valid feed types (atom? supported by "atom_0.3")
* Keep maximum number of entries (prune from list when oversized).
