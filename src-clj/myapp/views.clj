(ns myapp.views
  (:require [hiccup
             [page :refer [html5]]
             [page :refer [include-js]]]))

(defn index-page [data]
    (html5
      [:head
        [:title "Hello World"]
        (include-js "/js/main.js")]
      [:body
        [:p (str data)]]))
