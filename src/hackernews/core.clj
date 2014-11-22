(ns hackernews.core
  (:gen-class)
  (:use nav.core
        ring.util.response
        ring.middleware.resource
        ring.middleware.file-info)
  (:require [ring.adapter.jetty :as jetty-adapter]
            [environ.core :refer [env]]
            [hackernews.api  :as api]
            [hackernews.html :as html]
            [hackernews.views.stories.index :as story-index-views]
            [hackernews.views.stories.show :as story-show-views]
            [hackernews.views.users.show :as user-show-views]))

(defn front-page-handler
  "Shows all stories on the front page of Hacker News."
  [request]
  (response
    (if-let [limit (get-in request [:params :limit])]
      (story-index-views/page (api/get-front-page limit))
      (story-index-views/page (api/get-front-page)))))

(defn show-story-handler
  "Shows a particular story and its comments."
  [request]
  (response
    (let [story-id (get-in request [:params :id])]
      (story-show-views/page (api/get-item-deep story-id)))))

(defn show-user-handler
  "Shows a particular user's information, as well as what they submitted."
  [request]
  (response
    (let [username (get-in request [:params :username])]
      (user-show-views/page (api/get-user username)))))

(def routes {
  [:get "/"]                front-page-handler
  [:get "/stories/:id"]     show-story-handler
  [:get "/users/:username"] show-user-handler
})

(def app
  "This is the HTTP handler function for the website."
  (-> (combine-routes routes)
      (html/wrap-generate-html)
      (wrap-resource "public")
      (wrap-file-info)))

(defn -main
  "This is the entry point into the application. It runs the server."
  [& [port]]
  (let [chosen-port (or port (env :port) "3000")
        parse-int #(Integer/parseInt (re-find #"\A-?\d+" %))]
    (jetty-adapter/run-jetty app {:port (parse-int chosen-port) :join? false})))
