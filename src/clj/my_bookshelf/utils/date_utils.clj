(ns my-bookshelf.utils.date-utils
  "Utility functions for date handling.
  You can find interop stuff here for conversion between new java-time API and old Date api."
  (:import java.time.LocalDate))

;;; timezone that should be used for every date / time related data in whole application
(def timezone (java.time.ZoneId/of "UTC"))

(defn convert-date
  "Convert date from string representation 'yyyy-MM-dd' to the java.util.Date.
  Do nothing if date is not string."
  [date]
  (if (string? date)
    (clojure.instant/read-instant-date date)
    ;; If it's not string we assume that it's already java.util.Date.
    ;; This also handles the `nil` case.
    date))

(defn to-date
  "Converts java.time.LocalDate to the java.util.Date.
  Check http://stackoverflow.com/questions/22929237/convert-java-time-localdate-into-java-util-date-type."
  [^LocalDate local-date]
  (-> local-date
      (.atStartOfDay timezone)
      .toInstant
      java.util.Date/from))

(defn to-local-date
  "Converts the java.util.Date to the java.time.LocalDate.
  Check http://stackoverflow.com/questions/21242110/convert-java-util-date-to-java-time-localdate."
  [^LocalDate date]
  (-> date
      .toInstant
      (.atZone timezone)
      .toLocalDate))

