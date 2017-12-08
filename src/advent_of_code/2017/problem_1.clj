(ns advent-of-code.2017.problem-1)


(defn str->nums
  [s]
  (map #(Integer/parseInt (str %)) s))


(defn get-pairs
  [nums]
  (partition 2 1 (concat nums (take 1 nums))))


(defn sum-matches
  [pairs]
  (->>
    pairs
    (filter (fn [pair] (= (first pair) (second pair))))
    (map first)
    (reduce + 0)))


(defn solve
  [input]
  (sum-matches (get-pairs (str->nums input))))


(defn half-twist
  [xs]
  (let [shift (/ (count xs) 2)
        splits (split-at shift xs)]
    (concat (second splits) (first splits))))


(defn get-twist-pairs
  [nums]
  (map vector nums (half-twist nums)))


(defn solve2
  [input]
  (sum-matches (get-twist-pairs (str->nums input))))
