(ns addition.core)

;; Create first input number
(let [input (. js/document (createElement "input"))]
  (set! (. input -innerHTML) 0)
  (set! (. input -id) "firstOperand")
  (. (. js/document -body) (appendChild input)))

;; Create "+" label
(let [label (. js/document (createElement "label"))]
  (set! (. label -innerHTML) "+")
  (. (. js/document -body) (appendChild label)))

;; Create second input number
(let [input (. js/document (createElement "input"))]
  (set! (. input -innerHTML) 0) 
  (set! (. input -id) "secondOperand")
  (. (. js/document -body) (appendChild input)))

;; Create button to calculate sum with wasm
(let [button (. js/document (createElement "button"))] 
  (set! (. button -innerHTML) "compute result in wasm")
  (set!
   (. button -onclick)
   (fn [] (js/alert
           (. js/window (addWasm
            (js/parseInt (. (. js/document (getElementById "firstOperand")) -value))
            (js/parseInt (. (. js/document (getElementById "secondOperand")) -value)))))))
  (. (. js/document -body) (appendChild button)))
