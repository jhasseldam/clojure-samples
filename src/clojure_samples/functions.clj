(ns samples.functions)
;; # Functions

;; Define a function with the name: say-hello
(defn say-hello
    "Greet somebody"
    [name] (println "Hello" name))

;; Define a function which squares a number and map a vector over this function
(defn square
    "Squares a number"
    [n] ( * n n))

(map square (range 1 100)) ;; Square the numbers 1 to 100

;; A function with two arguments
(defn hello-both
    ([person1 person2] (println "Hello" person1 "and" person2)))

;; Arity overloading
;; The following function has arity overloading for 1 or zero arguments respectively
(defn print-favorite
    ([name] (println name "is my favorite"))
    ([] (print-favorite "C")))

(print-favorite)

;; Functions with a variable number of arguments are called: variadic functions
;; Apply unpacks the sequence of arguments and send them to println as individual arguments 
(defn variadic-greeter
    [& persons] (apply println "Hello to" persons))

(variadic-greeter "World" "Moon" "Sun" "Stars" "Universe")

;; We can also map all arguments to a different functions for example
(defn negate [n] (* n -1))

(defn negate-them-all
    [& numbers]
    (map negate numbers))

;; Deconstruct a vector into named elements. Now first and second are single elements: first and second element 
;; of the parameter vector respectively. The rest of the elements (if any) are stored in "rest"
(defn deconstruct-vector
    [[first second & rest]]
    (println "First element is" first)
    (println "Second element is" second)
    (println "The rest of the vector is" rest))
