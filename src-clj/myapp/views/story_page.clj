(ns myapp.views.story-page
  (:require [hiccup
             [page :refer [html5]]
             [page :refer [include-js include-css]]]))

(defn story-header [story]
  [:header {:class "story-header"}
    [:h2 (story "title")]
    [:h3 "By: " (story "by")]])

(defn comment-list-item [comment]
  [:div {:class "comment"}
    [:h4 (comment "by")]
    [:p (comment "text")]])

(defn comment-section [comments]
  (map comment-list-item comments))

(defn page [story]
  (html5
    [:head
      [:title (story "title")]
      (include-js "/js/main.js")
      (include-css "/css/main.css")]
    [:body
      (story-header story)
      (comment-section (story "comments"))]))
