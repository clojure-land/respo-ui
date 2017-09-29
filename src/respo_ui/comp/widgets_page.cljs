
(ns respo-ui.comp.widgets-page
  (:require-macros [respo.macros :refer [defcomp div input textarea button span a <>]])
  (:require [respo.core :refer [create-comp create-element]]
            [respo.comp.space :refer [=<]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn option [props & children] (create-element :option props children))

(defn select [props & children] (create-element :select props children))

(defcomp
 comp-widgets-page
 (states)
 (let [state (:data states)]
   (div
    {}
    (div
     {}
     (<> "Widgets")
     (=< 8 nil)
     (a
      {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/widgets_page.cljs",
       :target "_blank",
       :inner-text "Source"}))
    (div
     {}
     (<> span "Some text as description" ui/text-label)
     (=< nil 16)
     (<> span "clickable" ui/clickable-text))
    (=< nil 16)
    (div
     {}
     (button {:style (merge ui/button {:background-color colors/attractive})} (<> "Yes"))
     (=< 16 nil)
     (button {:style (merge ui/button {:background-color colors/irreversible})} (<> "Yes"))
     (=< 16 nil))
    (=< nil 16)
    (div
     {}
     (input
      {:placeholder "Some short text",
       :value state,
       :style ui/input,
       :event {:input (fn [e dispatch! mutate!] (mutate! (:value e)))}})
     (=< 16 nil)
     (button {:style (merge ui/button)} (<> "Add"))
     (=< 16 nil)
     (<> span "nothing" ui/text-label))
    (=< nil 16)
    (div
     {}
     (select
      {:style ui/select}
      (option {:selected true, :inner-text "Haskell"})
      (option {:selected true, :inner-text "Clojure"})
      (option {:selected false, :inner-text "OCaml"})))
    (=< nil 16)
    (div
     {}
     (textarea {:placeholder "Some long text", :style ui/textarea})
     (=< 16 nil)
     (button {:style (merge ui/button)} (<> "Add"))))))
