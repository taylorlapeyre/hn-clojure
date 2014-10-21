(ns hackernews.views.util)

(defn link
  "Simple helper function for creating HTML links."
  [text href]
  [:a {:href href} text])
