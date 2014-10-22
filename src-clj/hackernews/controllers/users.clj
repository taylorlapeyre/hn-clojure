(ns hackernews.controllers.users
  (require [hackernews.views.users.show  :as show-views]
           [hackernews.api :as api]))

(defn show
  "Shows a particular user's information, as well as what they submitted."
  [username]
  (show-views/page (api/get-user username)))
