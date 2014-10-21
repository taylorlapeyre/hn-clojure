(ns myapp.hackernews
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(def hn-url "https://hacker-news.firebaseio.com/v0")

(defn get-json [url]
  (println "GET " url)
  (->>
    (client/get url)
    (:body)
    (json/read-str)))

(defn get-front-page-story-ids []
  (get-json (str hn-url "/topstories.json")))

(defn get-item [item-id]
  (get-json (str hn-url "/item/" item-id ".json")))

(defn get-story-comments [story]
  (map get-item (get story "kids")))

(defn get-story-with-comments [story-id]
  (let [story (get-item story-id)]
    (assoc story "comments" (get-story-comments story))))

(defn get-front-page []
  (map get-item (get-front-page-story-ids)))
