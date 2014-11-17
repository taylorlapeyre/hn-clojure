![hn](http://i.imgur.com/TvtPttG.gif)

# Hacker News in Clojure

This is an implementation of the website [Hacker News](http://news.ycombinator.com). It uses the official Hacker News [API](https://github.com/HackerNews/API).

### Features
- Look at front page stories
- View nested comments for each story
- See a user's submitted stories
- That's about it.

### How is it done?

The Hacker News API is pretty simple, and it only takes about [50 lines](https://github.com/taylorlapeyre/hn-clojure/blob/master/src-clj/hackernews/api.clj) to comprehensively access it.

HTML is generated via the [Hiccup](https://github.com/weavejester/hiccup) library, which translates Clojure data structures into HTML. If Hiccup sounds interesting to you, you might be interested in [making it yourself](https://gist.github.com/taylorlapeyre/7739c361a4f98d280722). It's a fun problem.

I match routes to route handlers using [Compojure](https://github.com/weavejester/compojure). I thought Compojure was pretty cool, so I [made that](https://github.com/taylorlapeyre/nav), too.

Finally, [Ring](http://github.com/ring-clojure/ring) ties everything togther with a very simple HTTP interface.

### What's left?

At the moment, everything is done in Clojure. I plan to add some Clojurescript for collapsing comments, etc.

The website is a little slow because I am waiting for every item to come back before rendering the page. This can be faster by rendering items on the front end as they come in via Reagent.

### Running it Yourself

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
