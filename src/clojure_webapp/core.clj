(ns clojure-webapp.core)

;; now any http request will return the contents of the file test.txt

(defn example-handler [request]
 {:body (java.io.File. "test.txt")}
 )

(defn on-init []
  (:println "Initializing sample webapp!"))

(defn on-destroy []
  (:println "Destroying sample webapp!"))

(defn foo 
  "I don't do a whole lot"
  [x]
  (println x "Hello, world!"))
