; <p>    Problem - super queens puzzle

;super-queens.lisp is the classical problem about the n queens plus the queens have the fucntionality to move as a knight</p>

;<p>This program is the solution for the fourth assignment for AI in Teesside
;University.</p>
;There is a trivial solution for 1 x 1, but the first 'honest'
;superqueen solution occurs at board size 10 x 10. There are 4 solutions for 10 x 10.
;and there are 44 solutions for  11 x 11 size

; <p>AJP-P5-2012-2013-SOLUTION is free software: you can redistribute it and/or
;modify it under the terms of the GNU General Public License as published by
;the Free Software Foundation, either version 3 of the License, or (at your
; option) any later version.</p>
 
; <p>This program is distributed in the hope that it will be useful, but
; WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
; FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
; details.</p>
 
; <p>You should have received a copy of the GNU General Public License along
; with this program. If not, see http://www.gnu.org/licenses/.</p>
 
; <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk & Fernando Candiani M2230826@live.tees.ac.uk  14-February-2013 </p>

; -----------------------------------
(defun replace-nth (rows place newvalue)
  (cond 
    ((null rows) 
      ()
     )
    ((eq place 0) 
     (cons newvalue (cdr rows) )
     )
    (t
     (cons (car rows) (replace-nth (cdr rows) (- place 1) newvalue))
     )
   )
  )

;The function is-save-queen-movement (rows x y)
; check if it is a safe move for a queen
; to be performed by the piece.
; -----------------------------------
(defun is-save-queen-movement (rows x y)
  (let ((i 1))
    (loop
      (when (> i y) (return (horse-movement rows x y)))
      (if (or (eq (nth (- y i) rows) x)
              (eq (nth (- y i) rows) (- x i))
              (eq (nth (- y i) rows) (+ x i))  )  
          (return))
      (incf i)
    ))
  )
; -----------------------------------

;The function is-save-horse-movement (rows x y)
; check if it is a safe move for a horse
; to be performed by the piece.
; -----------------------------------
(defun is-save-horse-movement (rows x y)
   (let ((i -2))
     (loop
	  (when (> i -1)  (return t) )
	  (let ((is-inside (+ y i) ))
	    ; checks whenever the movement is not going to be performed outside
	    ; the chess board.
	     (if (and (>= is-inside 0) (< is-inside (length rows)))
		   ;(format t "~D~%" is-inside)
		   (if (= (mod i 2) 0) 
			  (if (or (= (nth is-inside rows) (+ x 1)) (= (nth is-inside rows) (- x 1)))
				(return)
				;(format t "x+1: ~D~%, nth: ~D~%" (+ x 1) (nth is-inside rows))
			   )
			  (if  (or (= (nth is-inside rows) (+ x 2)) (= (nth is-inside rows) (- x 2)))
				(return)
				;(format t "x+2: ~D~%, nth: ~D~%" (+ x 2) (nth is-inside rows))
			   )
		    )
		   ;(format t "Not inside the board ")
	      )
	   )
	  (incf i)
      ))
 )

; Function that displays the results
; as the user requested
; -----------------------------------
(defun result (rows output)
  (cond ((= output 0)
          (format t "r: ~S~%" rows)
         )
        ((= output 1)
          t
         )
        (t
         (format t "Output not supported")
         )
   )
 )
; -----------------------------------

; Backtracking depth first search
; -----------------------------------
(defun solver (function rows y &optional (output 0))
  (let ((x 0))
    (loop
      (when (>= x (length rows)) (return "finished"))
      (if (and (funcall function rows x y) (replace rows (replace-nth rows y x)) )
          (if (eq y (- (length rows) 1))      
              (result rows output) 
            (solver function rows (1+ y) output)
            )
        )
      (incf x)) 
   )
 )
; -----------------------------------

; Function that wrapps the others.
; -----------------------------------
(defun n-queens (function size &optional (output 0))
  (solver function (make-list size :initial-element 0) 0 output)
 )
; -----------------------------------


;(N-QUEENS #'IS-SAVE-QUEEN-MOVEMENT 10)
;r: (2 5 8 0 3 6 9 1 4 7)
;r: (3 7 0 4 8 1 5 9 2 6)
;r: (6 2 9 5 1 8 4 0 7 3)
;r: (7 4 1 9 6 3 0 8 5 2)