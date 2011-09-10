(ns com.lps.style)

(use 'cssgen)
(use 'cssgen.types)

(defn defaultstyle
  []
  (css
    (rule "h1"
       :width (% 100)
       :margin-top (em 0.5)
       :text-align "center"
       :font-size (pt 40)
    )
    (rule "body"
        :background-image "url(/images/bright_squares.png)"
        :background-repeat :repeat
        :margin 0
        :font-family "teeshirt, serif"
    )
    (rule "p"
      :font-size (px 40)
    )
    (rule "#content"
        :width (px 750)
        :margin-left :auto
        :margin-right :auto
        :background-color :white
        :height (% 100)
        :min-height (px 400)
        :padding-top (px 1)
        :text-align :center
        :border-left   ["#a9a9a9" :double :medium]
        :border-right  ["#a9a9a9" :double :medium]
        :border-bottom ["#a9a9a9" :double :medium]
        :border-bottom-left-radius (px 30)
        :border-bottom-right-radius (px 30)
    )
  ))

