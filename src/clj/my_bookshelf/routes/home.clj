(ns my-bookshelf.routes.home
  (:require [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET]]
            [java-time :as t]
            [my-bookshelf.layouts.home :as l]
            [my-bookshelf.model.book :refer [author book]]
            [ring.util.http-response :as response]))

(defn home-page []
  ;; TODO remove hardcoded data
  (l/render-home [(book
                   :title "Clojure Applied"
                   :authors [(author :first-name "Ben" :last-name "Vandgrift")
                             (author :first-name "Alex" :last-name "Miller")]
                   :issued (t/local-date 2015 9 1)
                   :status "Reading")]))

(defroutes home-routes
  (GET "/" [] (home-page)))
