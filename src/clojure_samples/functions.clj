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

(negate-them-all 1 2 3 4 5 6 6)

;; Lets imagine we wanted a negate-them-all functions which takes a set instea
;; The difference is subtle but: & numbers means arguments and just numbers means a single argument
;; which in this case happens to be a vector
(defn negate-them-all'
  [numbers]
  (map negate numbers))
  
(negate-them-all' (range 1 100))
  

;; # DECONSTRUCTION
;; Think of deconstruction as a way to tell Clojure how to associate names with values

;; Automatically decontruct a list of arguments when calling a function into: 
;; friend which contains the first argument and & friends which contains the rest
(defn deconstruct-args 
    [first & rest]
    (println "The first friend is" first)
    (map println rest))

;; This decontruction is possible with more aguments as well
(defn deconstruct-more-args
    [first second & rest]
    (println "First:" first)
    (println "Second" second)
    (map println rest))

;; It is also possible to descontruct a vector. Notice the difference that the arg vector is given as a vector with named values
;; as opposed to just a vector with binding names as above
;; This is similar to the pattern matching style: | first::second::third -> ... in F#
(defn deconstruct-vector
    [[first second third]]
    (println "First: " first)
    (println "Second: " second)
    (println "Third: " third))

;; Even though the parms are defined as a vector, it is also possible to pass a list as an argument to this function
;; the list will automatically be converted to a vector:
(deconstruct-vector ["One" "Two" "Three"]) ;; This is fine
(deconstruct-vector '("One" "Two" "Three")) ;; This is also fine

;; Deconstruction a map looks very similar
(defn deconstruct-map
    [{height :height width :width}]
    (println "Height = " height)
    (println "Width = " width)
    (println "The area is: " (* height width)))


;; # ANONYMOUS FUNCTIONS
;; Using functions without first having to name them

;; Square a vector of numbers using an anonymous square function
(defn demo-anonymous-function
    [numbers]
    (map (fn [n] (* n n)) numbers))

;; Clojure suports a short syntax for writing anonymous functions
;; The following is exactly the same as above:
(defn demo-short-anonymous-function
    [numbers]
    (map #(* % %) numbers))

;; Recurive calls and looping
;; A naive non-tail-call-optimized approach to recursively calculating the sum of numbers from 1 to n
(defn recursive-sum ([n]
     (if (= n 0)
         0
         (+ n (recursive-sum (- n 1)))))) 

;; Recursive functions are more effectively handled by using a loop instead. 
;; This will also lead to better performance
;; Here the two arguments in the loop are both declared with default values of 0
(defn loop-sum ([n]
  (loop [i 0 
         sum 0]
      (if (<= i n)
          (recur (inc i) (+ i sum))
          sum))))


;;The built-in map function works on sequences and is indefferent to the actual datastructure given
(defn singing [item]
  (println "Head shoulders knees and" item "knees and" item))

;; So we can all above implementation with
;; Vectors
(map singing ["toes" "fingers"])
;; Lists
(map singing '("eyes" "mouth"))
;; or Hash-sets
(map singing #{"ham" "cheese"})