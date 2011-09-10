(ns com.lps.webapp
  (:use compojure.core ring.adapter.jetty
        com.lps.numbers
        com.lps.views
        com.lps.style
        )
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.util.response :as ringresponse]))

(defroutes main-routes
  (GET "/" [] (index-page))
  (POST "/" [number] (ringresponse/redirect (str "/" number)))
  (GET ["/:n", :n #"-?[0-9]+"] [n] (number-page (bigint n)))
  (GET ["/:n/english", :n #"-?[0-9]+"] [n] (number-as-words (bigint n)))
  (GET "/style.css" [] (-> (ringresponse/response (defaultstyle))
                           (ringresponse/content-type "text/css")))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (handler/site main-routes))

(defn -main [& args]
  (let [port-str (System/getenv "PORT")
        port (Integer/parseInt (if (nil? port-str) "8000" port-str))]
    (run-jetty app {:port port})))
