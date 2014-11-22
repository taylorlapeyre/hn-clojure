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
      (util/user-link (story "by") (story "by")) " | "
      (util/story-link
        (str (count (story "kids")) " comments") (story "id"))]])

(defn page [stories]
  (main-layout {:title "Hacker News"}
    (concat [:ol] (map story-html stories))))
