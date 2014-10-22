(ns hackernews.views.stories.index
  (:require [hackernews.views.layout :refer [main-layout]]
            [hackernews.views.util :as util]))

(defn story-html
  "The HTML for each story on the front page."
  [story]
  [:li {:class "story"}
    (util/link (story "title") (story "url"))
    [:p
      (story "score") " points by "
      (util/link (story "by") (str "/users/" (story "by"))) " | "
      (util/link
        (str (count (story "kids")) " comments")
        (str "/stories/" (story "id")))]])

(defn page [stories]
  (main-layout {:title "Hacker News"}
    [:ol (map story-html stories)]))
