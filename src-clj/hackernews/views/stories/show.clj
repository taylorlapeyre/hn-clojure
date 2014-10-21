(ns hackernews.views.stories.show
  (:require [hackernews.views.layout :refer [main-layout]]
            [hackernews.views.util :as util]))

(defn story-header
  "Displays information about the story (title, etc)"
  [story]
  [:header {:class "story-header"}
    (util/link [:h2 (story "title")] (story "url"))
    [:h3 "By: " (story "by")]])

(defn comment-section
  "Shows each top level comment about the story."
  [comments]
  (letfn [(comment-html [comment]
            [:div {:class "comment"}
              [:h4 (comment "by")]
              [:p (comment "text")]])]
    (map comment-html comments)))

(defn page [story]
  (main-layout {:title (str "HN: " (story "title"))}
    (story-header story)
    (comment-section (story "comments"))))
