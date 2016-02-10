(ns clojure-webapp.core)

;; now any http request will return the contents of the file test.txt
;; can specify a status code. 500 will return that error code instead of a 200. response body stays the same.
;; try curl -v http://localhost:3000 to see it

(defn example-handler [request]
 {:body (java.io.File. "test.txt")
  :status 500}
 )

(defn on-init []
  (:println "Initializing sample webapp!"))

(defn on-destroy []
  (:println "Destroying sample webapp!"))

(defn foo 
  "I don't do a whole lot"
  [x]
  (println x "Hello, world!"))
