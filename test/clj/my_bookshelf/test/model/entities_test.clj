(ns my-bookshelf.test.model.entities-test
  (:require [java-time :as t]
            [my-bookshelf.model.entities :as e]
            [expectations :refer :all]))

(expect [(e/book :id "1" :title "Pure Joy" :issued #inst "2017-03-07" :status "created"
                 :authors [(e/author :id "1" :first-name "Juraj" :last-name "Martinka")])
         (e/book :id "2" :title "Pure Fun" :issued #inst "2016-03-07" :status "reading"
                 :authors [(e/author :id "1" :first-name "Juraj" :last-name "Martinka")
                           (e/author :id "2" :first-name "John" :last-name "Doe")])]
        (e/books-with-authors '({:id "1", :title "Pure Joy", :issued #inst "2017-03-07T00:00:00.000-00:00",
                                :status "created", :id_2 "1", :first_name "Juraj", :last_name "Martinka"}
                               {:id "2", :title "Pure Fun", :issued #inst "2016-03-07T00:00:00.000-00:00",
                                :status "reading", :id_2 "1", :first_name "Juraj", :last_name "Martinka"}
                               {:id "2", :title "Pure Fun", :issued #inst "2016-03-07T00:00:00.000-00:00",
                                :status "reading", :id_2 "2", :first_name "John", :last_name "Doe"})))

