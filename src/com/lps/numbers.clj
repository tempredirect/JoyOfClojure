(ns com.lps.numbers
  (:require [clojure.string :as str] [clojure.zip :as zip]))

(defn triplets "Splits a string into three char blocks (triplets) with the first having the odd number of chars"
  [s] (let [len (.length s)
            modlen (mod len 3)
            chunksize (if (zero? modlen) 3 modlen)
            ]
  (cons (.substring s 0 chunksize)
    (lazy-seq (if (> len chunksize)
      (triplets (.substring s chunksize)))))))

(def words
  "Dictionary of words for the transalation of digits to words"
  { 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten"
    11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eigthteen" 19 "nineteen" 20 "twenty"
    30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"
    })

(defn triplet-as-words
  "given a three digit (or less string) returns the word representation of it"
  [s]
    (let [value (Integer. (str s))
          mod10 (mod value 10)]
      (cond
        (> value 99) (str (words (int (/ value 100))) " hundred"
                        (if (not= "00" (.substring s 1))
                          (str " and " (triplet-as-words (.substring s 1)))))
        (zero? value) nil
        (contains? words value) (words value)
        :else (str (words (- value mod10))
                (if (not= 0 mod10) (str "-" (words mod10)))))
  ))

(defn number-as-words [number]
  (.trim (str/join " "
    (reverse
      (map #(str/join " " [%2 %1])  [ "" "thousand" "million" "billon" "trillon" "quadrillion" "quintillion" "sextillion"]
        (reverse (map triplet-as-words (triplets (str number)))))))))

;(println (triplets "232"))
;(println (triplets "1232232"))
;
;(println (number-as-words 123))
;(println (number-as-words 1023))
;(println (number-as-words 57))
;(println (number-as-words 123123157))
;(println (number-as-words 1423323699))

;(println "1   " (str/join " and " (triplet-as-words "1")))
;(println "10  " (triplet-as-words "10"))
;(println "100 " (triplet-as-words "100"))
;(println "111 " (str/join " and " (triplet-as-words "111")))
;(println "111 " (str/join " and " (triplet-as-words "111")))

