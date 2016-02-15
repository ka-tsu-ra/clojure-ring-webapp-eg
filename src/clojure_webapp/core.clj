(ns clojure-webapp.core)

;; can use 'headers' keyword to set some headers.
;; now any http request will result in redirect to the url specified
;; changed status code to 301 - moved permanently.
;; try curl -v http://localhost:3000 to see it

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
