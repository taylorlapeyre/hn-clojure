(ns hackernews.views.users.show
  (:require [hackernews.views.layout :refer [main-layout]]
            [hackernews.views.util :as util]))

(defn user-header
  "Displays information about the user (username, etc)"
  [user]
  [:header {:class "user-header"}
    [:h2 (user "id")]
    [:p "Karma: " (user "karma")]])

(defn submitted-html
  [story]
  [:div {:class "submitted-story"}
    (util/link [:h4 (story "title")] (story "url"))])

(defn submitted-section
  "Shows each story submitted by a user."
  [stories]
  (map submitted-html stories))

(defn page [user]
  (main-layout {:title (str "HN: " (user "id"))}
    (user-header user)
    (submitted-section (user "stories"))))
