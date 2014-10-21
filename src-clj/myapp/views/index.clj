(ns myapp.views.index
  (:require [hiccup
             [page :refer [html5]]
             [page :refer [include-js include-css]]]))

(defn story-list-item [story]
  [:div {:class "story"}
    [:a {:href (str "/story/" (story "id"))} [:h4 (story "title")]]
    [:p (str "Score: " (story "score"))]
    [:p "By: " [:strong (story "by")]]])

(defn story-list [stories]
  (map story-list-item stories))

(defn page [stories]
  (html5
    [:head
      [:title "Hello World"]
      (include-js "/js/main.js")]
    [:body (story-list stories)]))
