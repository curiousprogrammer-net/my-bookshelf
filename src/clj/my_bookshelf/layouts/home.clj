(ns my-bookshelf.layouts.home
  (:require
   [hiccup.core :refer [html]]))

(defn render-home [books]
  (html
   [:body
    [:h1 "My Bookshelf"]
    [:h2 "My Books"]
    [:ul
     (for [b books]
       [:li (str (:title b)
                 "; "
                 (->>
                  (map #(str (:first-name %) " " (:last-name %)) (:authors b))
                  (clojure.string/join ", "))
                 "; "
                 (:issued b)
                 "; "
                 (:status b))])]]))
