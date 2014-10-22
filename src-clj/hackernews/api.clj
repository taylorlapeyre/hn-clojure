(ns hackernews.api
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

;; The base URL for the HN API.
(def base-url "https://hacker-news.firebaseio.com/v0")

(defn get-json
  "Given a URL, parses the body of the HTTP GET request as JSON."
  [url]
  (println "GET " url)
  (->>
    (client/get (str url ".json"))
    (:body)
    (json/read-str)))

(defn get-front-page-story-ids
  "Fetches an array of IDs to stories on the front page of HN."
  []
  (get-json (str base-url "/topstories")))

(defn get-item
  "Fetches the item with a given item-id from the HN API.
    NOTE: In HN terminology, an 'item' can be either a comment or a story."
  [item-id]
  (get-json (str base-url "/item/" item-id)))

(defn get-item-deep
  "Recursively fetches the story and all of its comments.
    WARNING: Very slow."
  [item-id]
  (let [item (get-item item-id)]
    (assoc item "comments" (map get-item-deep (item "kids")))))

(defn get-front-page
  "Fetches each story on the front page of HN. Takes an optional
  number of stories to fetch. Default is 50.
    Warning: Very slow."
  ([]      (map get-item (take 50 (get-front-page-story-ids))))
  ([limit] (map get-item (take (Integer. limit) (get-front-page-story-ids)))))
