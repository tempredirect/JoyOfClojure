(ns com.lps.views
  (:use [hiccup core page-helpers]
        com.lps.numbers))

(defn main-layout [title content]
  (html5
    [:head
      [:title title]
      [:script {:type "text/javascript" :src "http://use.typekit.com/hzg8sis.js"} ]
      [:script {:type "text/javascript"} "try{Typekit.load();}catch(e){}" ]
      (include-css "/style.css")]
    [:body
      [:div#content
       [:h1 title]
       content
      ]
    ]))

(defn index-page []
  (main-layout "Numbers"
    [:form {:action "/" :method "POST"}
     [:label {:for "number"} "type a number"]
     [:input {:id "number" :type "text" :name "number"}]
     [:input {:type "submit" :value "go"}]
    ]))


(defn number-page [number]
  (main-layout (str number)
    [:p.english [:strong (number-as-words number)]]))
