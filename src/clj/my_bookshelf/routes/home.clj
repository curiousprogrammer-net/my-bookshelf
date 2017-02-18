(ns my-bookshelf.routes.home
  (:require [my-bookshelf.layouts.home :as l]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (l/render-home []))

(defroutes home-routes
  (GET "/" [] (home-page)))
