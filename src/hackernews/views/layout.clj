(ns hackernews.views.layout
  (:require [hiccup
             [page :refer [html5]]
             [page :refer [include-js include-css]]]
            [hackernews.views.util :as util]))

(defn github-banner
  "From https://github.com/blog/273-github-ribbons"
  []
  [:a {:href "https://github.com/taylorlapeyre"}
    [:img {:style "position: absolute; top: 0; left: 0; border: 0;"
           :src "https://camo.githubusercontent.com/8b6b8ccc6da3aa5722903da7b58eb5ab1081adee/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f6c6566745f6f72616e67655f6666373630302e706e67"
           :alt "Fork me on GitHub"}]])

(defn main-header
  []
  [:header {:class "main-header"}
    [:img {:src "https://news.ycombinator.com/y18.gif"}]
    [:h1 "Hacker News"]
    (util/link "new" "/newest") " | "
    (util/link "threads" "https://news.ycombinator.com/threads") " | "
    (util/link "comments" "https://news.ycombinator.com/comments") " | "
    (util/link "show" "https://news.ycombinator.com/show") " | "
    (util/link "ask" "https://news.ycombinator.com/ask") " | "
    (util/link "jobs" "https://news.ycombinator.com/jobs") " | "
    (util/link "submit" "https://news.ycombinator.com/submit") " | "
    (util/link "taylorlapeyre/hn-clojure" "https://github.com/taylorlapeyre/hn-clojure")])

(defn main-layout
  "The main chrome of the website. Accepts a map that contains information
  about the page, and whatever html is to get rendered into the layout."
  [{:keys [title]} & page-content]
  [:html
    [:head
      [:title title]
      [:link {:href "/css/main.css" :rel "stylesheet"}]]
    [:body
      (main-header)
      (github-banner)
      (concat [:div {:class "content"}] page-content)]])
