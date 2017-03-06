(ns my-bookshelf.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [my-bookshelf.layout :refer [error-page]]
            [my-bookshelf.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [my-bookshelf.env :refer [defaults]]
            [mount.core :as mount]
            [my-bookshelf.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
   (-> #'home-routes
       (wrap-routes middleware/wrap-csrf))

       (route/not-found
        (:body
         (error-page {:status 404
                      :title "page not found"})))))

(defn app [] (middleware/wrap-base #'app-routes))
