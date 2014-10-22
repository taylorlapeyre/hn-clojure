(ns hackernews.views.util)

(defn link
  "Simple helper function for creating HTML links."
  [text href]
  [:a {:href href} text])

(defn user-link
  "Link to a user's profile."
  [text username]
  (link text (str "/users/" username)))

(defn story-link
  "Link to a story's comment page."
  [text story-id]
  (link text (str "/stories/" story-id)))
