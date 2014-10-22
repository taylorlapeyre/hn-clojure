(defproject hackernews "0.1.0"
  :description "A Hacker News implementation."
  :min-lein-version "2.0.0"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 ; Backend
                 [ring/ring-jetty-adapter "1.3.1"]
                 [environ "0.5.0"]
                 [compojure "1.1.6"]
                 [clj-http "1.0.0"]
                 [cheshire "5.3.1"]
                 [hiccup "1.0.4"]
                 ; Frontend
                 [org.clojure/clojurescript "0.0-2371"]
                 [reagent "0.4.2"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.7"]]
  :profiles {:uberjar {:aot :all}}
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:preamble ["reagent/react.js"]
                                   :output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :ring {:handler hackernews.routes/app}
  :uberjar-name "hackernews.jar"
  :main hackernews.routes)
