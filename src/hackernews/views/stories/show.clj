(ns hackernews.views.stories.show
  (:require [hackernews.views.layout :refer [main-layout]]
            [hackernews.views.util :as util]))

(defn story-header
  "Displays information about the story (title, etc)"
  [story]
  [:header {:class "story-header"}
    (util/link [:h2 (story "title")] (story "url"))
    (util/user-link [:h3 "By " (story "by")] (story "by"))])

(defn comment-html
  "Recursively generates the HTML comment tree for a given comment."
  [comment]
  [:div {:class "comment"}
    (util/user-link [:h4 (comment "by")] (comment "by"))
    [:p (comment "text")]
    (cons :ul (map comment-html (comment "comments")))])

(defn page [story]
  (main-layout {:title (str "HN: " (story "title"))}
    (cons (story-header story)
          (map comment-html (story "comments")))))