(ns hackernews.hello
  (:require [reagent.core :as reagent :refer [atom]]))

; NOTE: This doesn't do anything yet, but it will work if you run
; `hackernews.hello.run()` in the JS console.

(defn greeting [message]
  [:h1 message])

(defn simple-example []
  [:div [greeting "Hello World"]])

(defn ^:export run []
  (reagent/render-component [simple-example]
                            (.-body js/document)))
