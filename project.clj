(defproject hackernews "0.1.0"
  :description "A Hacker News implementation."
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [reagent "0.4.2"]
                 [clj-http "1.0.0"]
                 [org.clojure/data.json "0.2.5"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.7"]]
  :profiles {:uberjar {:aot :all}}
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:preamble ["reagent/react.js"]
                                   :output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :ring {:handler hackernews.routes/app})
