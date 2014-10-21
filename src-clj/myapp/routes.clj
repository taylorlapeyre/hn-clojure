(ns myapp.routes
  (:use compojure.core
        myapp.views
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn get-json [url]
  (->>
    (client/get url)
    (:body)
    (json/read-str)))

(defn item-id->title [id]
  (println "Getting Data for ID" id "...")
  (let [url (str "https://hacker-news.firebaseio.com/v0/item/" id ".json")]
    (get (get-json url) "title")))

(def hn-data (->>
               (get-json "https://hacker-news.firebaseio.com/v0/topstories.json")
               (first)
               (item-id->title)))

(defroutes main-routes
  (GET "/" [] (index-page hn-data))
  (route/resources "/")
  (route/not-found "Page not found."))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
