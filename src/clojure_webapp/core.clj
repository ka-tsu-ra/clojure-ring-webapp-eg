(ns clojure-webapp.core
 (:require [clojure-webapp.handlers :as handlers]))

;; require in the 3rd handler function which is in the separate file src/clojure-webapp/handlers.clj.
;; Reference it using its namespace.
;; Rem project.clj directs http requests to be routed according to function 'route-handler'.

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
  "/test3" (handlers/handler3 request)
  nil))

;; Reference the shortcut set in the require at the top using the :as keyword, ie handlers.
;; browsing to /test3 makes the handler function in separate file kick in.
;; can still browse to localhost:3000/test1 and localhost:3001/test2

(defn wrapping-handler [request]
 (if-let [resp (route-handler request)]
  resp
  {:status 404 :body (str "Not found: " (:uri request))}))

;; wrapping handler says if there's a response to the request out of the route-handler function, return the response. Is 'resp' a keyword??
;; otherwise, return the status 404 with the string above.
;; NB set wrapping-handler as the :ring :handler in project.clj. So now it is the mutha handler function.
 
