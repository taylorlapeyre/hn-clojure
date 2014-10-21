(ns myapp.routes
  (:use compojure.core
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [myapp.hackernews :as hn]
            [myapp.views.index :as index-views]
            [myapp.views.story-page :as story-views]))

(defroutes main-routes
  (GET "/" [] (index-views/page (hn/get-front-page)))
  (GET "/story/:id" [id]
    (story-views/page (hn/get-story-with-comments id)))
  (route/not-found "Page not found."))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
