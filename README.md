## Hacker News

This is an implementation of the website [Hacker News](http://news.ycombinator.com). It uses the official Hacker News [API](https://github.com/HackerNews/API).

It is written in Clojure and Clojurescript. At the moment, everything is done in Clojure. Right now, the front page is _super slow_ because I am getting each story synchronously. Once I write the logic to get stories in Clojurescript, it will be asynchronous and about 25x faster.
