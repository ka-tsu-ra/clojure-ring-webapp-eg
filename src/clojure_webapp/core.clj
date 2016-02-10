(ns clojure-webapp.core)

;; now any http request will return the request itself.
;; start server and browse to eg localhost:3000/uri_test?test=1 and see the request printed out.
;; nb no params or cookies maps in there. they can be coerced using middleware.

(defn example-handler [request]
 {:body (pr-str request)}
 )

;; specify the names of these functions in the project.clj file in the ring handler section
;; so that they run when you start up and close the server
(defn on-init []
  (:println "Initializing sample webapp!"))

(defn on-destroy []
  (:println "Destroying sample webapp!"))

(defn foo 
  "I don't do a whole lot"
  [x]
  (println x "Hello, world!"))
