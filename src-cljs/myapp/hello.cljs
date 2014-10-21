(ns myapp.hello
  (:require [reagent.core :as reagent :refer [atom]]))

(defn greeting [message]
  [:h1 message])

(defn simple-example []
  [:div [greeting "Hello World"]])

(defn ^:export run []
  (reagent/render-component [simple-example]
                            (.-body js/document)))
