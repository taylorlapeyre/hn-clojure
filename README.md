## Hacker News

This is an implementation of the website [Hacker News](http://news.ycombinator.com). It uses the official Hacker News [API](https://github.com/HackerNews/API).

At the moment, everything is done in Clojure. I plan to add some Clojurescript for collapsing comments, etc.

The website is _super slow_ because I am getting each story synchronously. Once I write the logic to get stories asynchronously, it will be exactly **100x faster.**

### Getting Up & Running

1. First, make sure that you have **Java** installed.

2. Then, install [Leiningen](https://github.com/technomancy/leiningen):
  ```bash
  $ brew install leiningen
  ```

3. Finally, start up the server:
  ``` bash
  $ cd hackernews
  $ lein ring server-headless
  ```

The website will be up on [localhost:3000](http://localhost:3000).
