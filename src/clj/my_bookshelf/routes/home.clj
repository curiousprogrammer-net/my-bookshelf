(ns my-bookshelf.routes.home
  (:require [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET POST]]
            [java-time :as t]
            [my-bookshelf.db.core :as db]
            [my-bookshelf.layout :as l]
            [my-bookshelf.model.entities :as m]
            [my-bookshelf.utils.date-utils :refer [to-date]]
            [ring.util.http-response :as response]))

(defn save-book!
  "Persists new boook"
  [{:keys [params]}]
  ;; TODO: save new book
)

(defn home-page []
  (l/render "home.html"  {:books (m/books-with-authors (db/get-books-with-authors))}))

(defn add-book-page []
  (l/render "add-book.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/add-book" [] (add-book-page))
  (POST "/books" request (save-book! request)))
