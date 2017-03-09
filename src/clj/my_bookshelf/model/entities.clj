(ns my-bookshelf.model.entities
  (:require [my-bookshelf.utils.date-utils :as d]))

(defrecord Author [id first-name last-name])

(defn author [{:keys [id first-name last-name]}]
  (->Author id first-name last-name))

(defrecord Book [id title authors ^java.util.Date issued status])

(defn book
  "creates a book from specified keys.
  Converts issued date from string to java.util.Date if necessary."
  [{:keys [id title authors issued status]}]
  (->Book id title authors (d/convert-date issued) status))


;;; TODO: use Specter to re-implement this function
;;; http://nathanmarz.com/blog/clojures-missing-piece.html
(defn- book-authors->book [[book-id book-authors]]
  (when-let [first-book-author (first book-authors)]
    (book {:id (:id first-book-author)
           :title (:title first-book-author)
           :issued (:issued first-book-author)
           :status (:status first-book-author)
           :authors (map (fn [book-author]
                           (author {:id (:id_2 book-author)
                                    :first-name (:first_name book-author)
                                    :last-name (:last_name book-author)}))
                         book-authors)})))

(defn books-with-authors
  "Accepting a list where each item contains full book and author info together,
  create a list of books conforming to Book defrecord where each book
  contains a full author info.
  Notice that in case of books with multiple authors, the same book will appear
  multiple times in input list"
  [books-with-authors]
  (->> books-with-authors
       (group-by :id)
       (map book-authors->book)))

