(ns user
  (:require [mount.core :as mount]
            my-bookshelf.core))

(defn start []
  (mount/start-without #'my-bookshelf.core/http-server
                       #'my-bookshelf.core/repl-server))

(defn stop []
  (mount/stop-except #'my-bookshelf.core/http-server
                     #'my-bookshelf.core/repl-server))

(defn restart []
  (stop)
  (start))


