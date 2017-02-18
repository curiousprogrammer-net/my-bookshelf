(ns my-bookshelf.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [my-bookshelf.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[my-bookshelf started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[my-bookshelf has shut down successfully]=-"))
   :middleware wrap-dev})
