(defproject hackernews "0.2.0"
  :description "A Hacker News implementation."
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-jetty-adapter "1.3.1"]
                 [ring "1.3.1"]
                 [environ "0.5.0"]
                 [nav "0.2.0"]
                 [clj-http "1.0.0"]
                 [cheshire "5.3.1"]
                 [hiccup "1.0.4"]]
  :plugins [[lein-ring "0.8.7"]]
  :profiles {:uberjar {:aot :all}}
  :ring {:handler hackernews.core/app}
  :uberjar-name "hackernews.jar"
  :main hackernews.core)
