(ns com.lps.numbers-test
   (:use clojure.test com.lps.numbers))

(deftest test-number-as-words-1
  (is (= "one" (number-as-words 1))))

(deftest test-number-as-words-2
  (is (= "one hundred" (number-as-words 100))))

(deftest test-number-as-words-3
  (is (= "one hundred and sixty" (number-as-words 160))))

(deftest test-triplets-1
  (is (= "1" (first (triplets "1")))))

(deftest test-triplets-2
  (is (= "1" (first (triplets "1222")))))

(deftest test-triplets-3
  (is (= "222" (second (triplets "1222")))))

(deftest test-triplets-4
  (is (= "444" (nth (triplets "121222333444") 3))))