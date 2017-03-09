(ns my-bookshelf.routes.home
  (:require [bouncer.core :as b]
            [bouncer.validators :as v]
            [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET POST]]
            [java-time :as t]
            [my-bookshelf.db.core :as db]
            [my-bookshelf.layout :as l]
            [my-bookshelf.model.entities :as m]
            [my-bookshelf.utils.date-utils :refer [to-date]]
            [ring.util.http-response :as response]))

(defn- validate-book
  [book]
  (first (b/validate
          book
          :title v/required)))

(defn- save-book!
  "Persists new book defined by a form params in request.
  Book must be valid."
  [{:keys [params]}]
  (if-let [errors (validate-book params)]
    (response/bad-request {:errors errors})
    (do
      (db/create-book! (m/book params))
      (response/see-other "/"))))

(defn home-page []
  (l/render "home.html"  {:books (m/books-with-authors (db/get-books-with-authors))}))

(defn add-book-page []
  (l/render "add-book.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/add-book" [] (add-book-page))
  (POST "/books" request (save-book! request)))
