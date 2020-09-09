
;; # VECTORS
;; Vectors are similar to arrays

[3 2 1]
["Hello", 1 , true] ;; Doesn't have to contain same data types

(get [1 2 3] 0) ;; get element on position 0
(get ["Hello", 1 , true] 2) 
(vector "well" "hello" "there") ;; Create a vector from the three string arguments 
(conj [1 2 3 4] 5) ;; Add an element to the end of a vector

;; # LISTS

'(1 2 3) ;; A list literal

;; get doesn't work on lists, but to get the nth element of a list, we can use the nth keyword
(nth '(1 2 3 4) 2) ;; Gives 3 cause we are still starting at 0
(list 1 "hello" [1 2 3]) ;; Create a list which contains a string, a number and a vector
(conj '(1 2 3 4) 5) ;; As opposed to vectors: the conj operation on a list adds the element to the end of the list
(get '(1 2 4 10) 7) ;; Returns nil cause 7 is not found in the list

;; # HASH-SETS
;; Collection of unique values

#{"Something" 42 '(1 2 3)} ;; A set containing a string, a number and a literal list of numbers
#{"Something" "Something" 42 "Something else" 42} ;; Runtime exception cause duplicate values
(hash-set "Something" "Something" 42 "Something else" 42) ;; Creates a hash set and removing duplicate values in the process
(conj #{1 2 3} 4 ) ;; End up with  #{1 2 3 4}
(conj #{1 2 3} 3) ;; Still only #{1 2 3} because to value we are trying to add already exists in the set
(set [1 2 3 4]) ;; Create a set from a vector
(set '(1 2 3 4)) ;; Create a set from a list
(contains? #{1 2 3 4 } 4) ;; Returns true if 4 is found in the set
(:a #{:z :y :h :a}) ;; Returns the keyword if it is found in the set
(get #{"Well" "hello" "there"} "good day") ;; Returns nil because "good day" is not found in the set