(ns my-bookshelf.utils.date-utils
  "Utility functions for date handling.
  You can find interop stuff here for conversion between new java-time API and old Date api."
  (:import java.time.LocalDate))

(defn to-date
  "Converts java.time.LocalDate to the java.util.Date.
  Check http://stackoverflow.com/questions/22929237/convert-java-time-localdate-into-java-util-date-type.
  zone-id is an ordinary string like \"UTC\""
  [^LocalDate local-date zone-id]
  (-> local-date
      (.atStartOfDay (java.time.ZoneId/of zone-id))
      .toInstant
      java.util.Date/from))


