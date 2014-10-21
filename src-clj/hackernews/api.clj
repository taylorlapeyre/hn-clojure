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

(defn get-story-comments
  "Fetches the comments to a given story from the HN API.
    WARNING: Very slow."
  [story]
  (map get-item (get story "kids")))

(defn get-story-with-comments
  "Fetches both the story info and each of its comments from the HN API.
    Warning: Very slow."
  [story-id]
  (let [story (get-item story-id)]
    (assoc story "comments" (get-story-comments story))))

(defn get-front-page
  "Fetches each story on the front page of HN.
    Warning: Very slow."
  []
  (map get-item (get-front-page-story-ids)))
