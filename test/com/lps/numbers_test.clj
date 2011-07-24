(ns com.lps.numbers-test
   (:use clojure.test com.lps.numbers))

(deftest test-number-as-words
  (is (= "one" (number-as-words 1))))

(deftest test-triplets-1
  (is (= "1" (first (triplets "1")))))

(deftest test-triplets-2
  (is (= "1" (first (triplets "1222")))))

(deftest test-triplets-3
  (is (= "222" (second (triplets "1222")))))

(deftest test-triplets-4
  (is (= "444" (take 4 (triplets "121222333444")))))