(ns clojure-webapp.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; at the moment any http request will return "Hello Clojure"
(defn example-handler [request]
  {:body "Hello Clojure!"})

;; specify the names of these functions in the project.clj file in the ring handler section
;; so that they run when you start up and close the server
(defn on-init []
  (:println "Initializing sample webapp!"))

(defn on-destroy []
  (:println "Destroying sample webapp!"))
