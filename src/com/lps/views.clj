(ns com.lps.views
  (:use [hiccup core page-helpers]
        com.lps.numbers))

(defn main-layout [title content]
  (html5
    [:head
      [:title title]
      (include-css "/css/style.css")]
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
    [:dl
     [:dt [:strong "English"]]
     [:dd (number-as-words number)]]))
