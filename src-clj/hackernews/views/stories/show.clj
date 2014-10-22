(ns hackernews.views.stories.show
  (:require [hackernews.views.layout :refer [main-layout]]
            [hackernews.views.util :as util]))

(defn story-header
  "Displays information about the story (title, etc)"
  [story]
  [:header {:class "story-header"}
    (util/link [:h2 (story "title")] (story "url"))
    (util/link [:h3 "By: " (story "by")] (str "/users/" (story "by")))])

(defn comment-html
  [comment]
  [:div {:class "comment"}
    (util/link [:h4 (comment "by")] (str "/users/" (comment "by")))
    [:p (comment "text")]
    [:ul (map comment-html (comment "comments"))]])

(defn comment-section
  "Shows each top level comment about the story."
  [comments]
  (map comment-html comments))

(defn page [story]
  (main-layout {:title (str "HN: " (story "title"))}
    (story-header story)
    (comment-section (story "comments"))))
