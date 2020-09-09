;; An if-then-else expression

(if true
    "This is the then-clause: Return this if true"
    "This is the else-else: Return this if false")

;; The else-clause is optional. So if you only have an if-then expression, this is how it would look: 
;; If the if-expression evaluates to false in the example below, then nil is returned

(if true
    "Return this if the expression is true")

;; If you need to do multiple things in the branches, we can use the do keyword

(if false
    (do (println "Yeah we hit the true branch")
    "This is the return value in the true branch")
    do (println "Oh no we hit the false branch")
    "This is the return value in the false branch"))

;; The when operator is a if-do without an else branch

(when true
    (println "Can't believe this worked")
    "This is the return value")