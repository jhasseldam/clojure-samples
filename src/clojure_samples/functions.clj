(ns samples.functions)
;; # Functions

;; Define a function with the name: say-hello
(defn say-hello
    "Greet somebody"
    [name]
        (println "Hello" name))

;; Define a function which squares a number and map a vector over this function
(defn square
    "Squares a number"
    [n]
        ( * n n))

(map square (range 1 100)) ;; Square the numbers 1 to 100

;; Arty overloading

(defn print-favorite
    ([name]
        (println name "is my favorite"))
    ([]
        (print-favorite "C")))

(print-favorite)