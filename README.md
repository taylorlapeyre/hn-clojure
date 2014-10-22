## Hacker News

This is an implementation of the website [Hacker News](http://news.ycombinator.com). It uses the official Hacker News [API](https://github.com/HackerNews/API).

At the moment, everything is done in Clojure. I plan to add some Clojurescript for collapsing comments, etc.

The website is _super slow_ because I am waiting for every item to come back before rendering the page. This can be faster by rendering items on the front end as they come in via Reagent.

### Getting Up & Running

1. First, make sure that you have **Java** installed.

2. Then, install [Leiningen](https://github.com/technomancy/leiningen):
  ```bash
  $ brew install leiningen
  ```

3. Finally, start up the server:
  ``` bash
  $ cd hackernews
  $ lein run
  ```

The website will be up on [localhost:3000](http://localhost:3000).

### Compiling Clojurescript

```bash
$ cd hackernews
$ lein cljsbuild once
# or...
$ lein cljsbuild auto
```
