(ns my-bookshelf.routes.home
  (:require
   [clojure.java.io :as io]
   [compojure.core :refer [defroutes GET POST]]
   [java-time :as t]
   [my-bookshelf.db.core :as db]
   [my-bookshelf.layouts.home :as l]
   [my-bookshelf.model.entities :as m]
   [ring.util.http-response :as response]
   [my-bookshelf.utils.date-utils :refer [to-date]]))

(defn save-book!
  "Persists new boook"
  [{:keys [params]}]
  ;; TODO: save new book
)

(defn home-page []
  (l/render-home (m/books-with-authors (db/get-books-with-authors))))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/books" request (save-book! request)))
