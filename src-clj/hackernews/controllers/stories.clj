(ns hackernews.controllers.stories
  (require [hackernews.views.stories.index :as index-views]
           [hackernews.views.stories.show  :as show-views]
           [hackernews.api :as api]))

(defn index
  "Shows all stories on the front page of Hacker News."
  []
  (index-views/page (api/get-front-page)))

(defn show
  "Shows a particular story and its comments."
  [story-id]
  (show-views/page (api/get-item-deep story-id)))
