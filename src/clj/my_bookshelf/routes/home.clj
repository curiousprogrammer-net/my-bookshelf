(ns my-bookshelf.routes.home
  (:require
   [clojure.java.io :as io]
   [compojure.core :refer [defroutes GET POST]]
   [java-time :as t]
   [my-bookshelf.db.core :as db]
   [my-bookshelf.layouts.home :as l]
   [my-bookshelf.model.entities :refer [author book]]
   [ring.util.http-response :as response]
   [my-bookshelf.utils.date-utils :refer [to-date]]))

(def books [(book
             :title "Clojure Applied"
             :authors [(author :first-name "Ben" :last-name "Vandgrift")
                       (author :first-name "Alex" :last-name "Miller")]
             :issued (to-date (t/local-date 2015 9 1) "UTC")
             :status "Reading")])

(defn save-book!
  "Persists new boook"
  [{:keys [params]}]
  ;; TODO: save new book
)

(defn home-page []
  ;; TODO remove hardcoded data
  (l/render-home (db/get-books)))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/books" request (save-book! request)))
