(ns my-bookshelf.layouts.home
  (:require
   [hiccup.core :refer [html]]))

(defn render-home [books]
  (html
   [:body
    [:h1 "My Bookshelf"]]))
