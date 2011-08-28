(defproject hello-world "0.0.1"
  :dependencies
    [[org.clojure/clojure "1.2.1"]
     [org.clojure/clojure-contrib "1.2.0"]
     [compojure "0.6.4"]
     [ring/ring-jetty-adapter "0.3.9"]]
  :dev-dependencies [[lein-ring "0.4.5"]]
  :ring {:handler com.lps.webapp/app})