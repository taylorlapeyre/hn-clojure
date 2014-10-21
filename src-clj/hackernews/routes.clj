(ns hackernews.routes
  (:use compojure.core [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route           :as route]
            [compojure.handler         :as handler]
            [compojure.response        :as response]
            [hackernews.controllers.stories :as stories]))

(defroutes main-routes
  (GET "/" [] (stories/index))
  (GET "/stories/:id" [id] (stories/show id))

  (route/resources "/")
  (route/not-found "Page not found."))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
