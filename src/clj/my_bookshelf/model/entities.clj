(ns my-bookshelf.model.entities)

(defrecord Author [first-name last-name])

(defn author [& {:keys [first-name last-name]}]
  (->Author first-name last-name))

(defrecord Book [title authors issued status])

(defn book [& {:keys [title authors issued status]}]
  (->Book title authors issued status))
