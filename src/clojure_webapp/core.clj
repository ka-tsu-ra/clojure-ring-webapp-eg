(ns clojure-webapp.core)

;; Now project.clj directs http requests to be routed according to function 'route-handler'.

(defn example-handler [request]
 {:headers {"Location" "http://www.ft.com"
	    "Set-cookie" "test=1"}
  :status 301}
 )

(defn on-init []
  (:println "Initializing sample webapp!"))

(defn on-destroy []
  (:println "Destroying sample webapp!"))

(defn foo 
  "I don't do a whole lot"
  [x]
  (println x "Hello, world!"))

(defn test1-handler [request]
 {:body "test1"})

(defn test2-handler [request]
 {:status 301 
  :headers {"Location" "http://www.ft.com"}})

(defn route-handler [request]
 (condp = (:uri request)
  "/test1" (test1-handler request)
  "/test2" (test2-handler request)
  nil))

;; browse to localhost:3000/test1 and localhost:3001/test2 to see it.
