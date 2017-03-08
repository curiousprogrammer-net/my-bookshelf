(ns my-bookshelf.test.utils.date-utils-test
  (:require [expectations :refer :all]
            [java-time :as t]
            [my-bookshelf.utils.date-utils :as d]))

(let [local-date (t/local-date "2015-02-01")]
  ;; expected epoch milliseconds - UTC timezone used
  (expect 1422748800000 (.getTime (d/to-date local-date))))

(expect (t/local-date "2015-02-01")
        (d/to-local-date (java.util.Date. 1422748800000)))
