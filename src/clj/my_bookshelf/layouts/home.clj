(ns my-bookshelf.layouts.home
  (:require
   [my-bookshelf.layout :as l]))

(defn render-home [books]
  (l/render "home.html"  {:books books}))

