(ns hackernews.views.layout
  (:require [hiccup
             [page :refer [html5]]
             [page :refer [include-js include-css]]]))

(defn main-layout
  "The main chrome of the website. Accepts a map that contains information
  about the page, and whatever html is to get rendered into the layout."
  [{:keys [title]} & rest-of-body]
  (html5
    [:head
      [:title title]
      (include-js "/js/main.js")
      (include-css "/css/main.css")]
    (let [body [:body
                 [:header {:class "main-header"}
                   [:h1 "Hacker News"]]]]
      (conj body rest-of-body))))
