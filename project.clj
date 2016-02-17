(defproject clojure-webapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
		[ring "1.2.0"]]
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler clojure-webapp.core/wrapping-handler
	 :init	  clojure-webapp.core/on-init
	 :port	  3000
	 :destroy clojure-webapp.core/on-destroy})
;; specifying port is optional. If none specified it will find the first available one
