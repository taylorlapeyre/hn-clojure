(ns hackernews.html)

(def void-tags
  "Tags that don't have matching closing tags."
  [:area :base :br :col :command :embed :hr :img
   :input :keygen :link :meta :param :source :track :wbr])

(defn- create-attrs
  "Takes a map of HTML attributes and values, returns a valid HTML
  attribute string."
  [attrs]
  (let [attr-html #(str " " (name (first %)) "=\"" (second %) "\"")]
    (apply str (map attr-html attrs))))
 
(defn make-html
  "Takes a normal HTML tree in clojure form and recursively generates
  a valid HTML string with the contents of the tree."
  [el]
  (cond
    (nil? el) ""
    (string? el) el
 
    (coll? el)
    (let [[tag & body] el
          tagname (name tag)]
      (if (coll? tag)
        (make-html (first tag))
        (if (contains? void-tags tag)
          (str "<" tagname (create-attrs (first body)) ">")
          (if (map? (first body))
            (str
              "<" tagname (create-attrs (first body)) ">"
                (apply str (map make-html (rest body)))
              "</" tagname ">")
            (str
              "<" tagname ">"
                (apply str (map make-html body))
              "</" tagname ">")))))))

(defn wrap-generate-html [handler]
  (fn [request]
    (let [response (handler request)]
      (prn (make-html (:body response)))
      (merge response {:body (make-html (:body response))}))))