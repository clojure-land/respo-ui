
(ns respo-ui.comp.widgets-page
  (:require [respo.alias :refer [create-comp create-element div input textarea]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.common :refer [on-input init-input update-input]]
            [respo-ui.style.colors :as colors]))

(defn option [props & children] (create-element :option props children))

(defn select [props & children] (create-element :select props children))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (comp-text "widgets" nil)
     (div {} (comp-text "Some text as description" ui/text-label))
     (comp-space nil 16)
     (div
      {}
      (div
       {:style (merge ui/button {:background-color colors/attractive})}
       (comp-text "Yes" nil))
      (comp-space 16 nil)
      (div
       {:style (merge ui/button {:background-color colors/irreversible})}
       (comp-text "Yes" nil))
      (comp-space 16 nil))
     (comp-space nil 16)
     (div
      {}
      (input
       {:style ui/input,
        :event {:input (on-input mutate!)},
        :attrs {:placeholder "Some short text"}})
      (comp-space 16 nil)
      (comp-text state ui/text-label))
     (comp-space nil 16)
     (div
      {}
      (select
       {:style ui/select}
       (option {:attrs {:selected true, :inner-text "Haskell"}})
       (option {:attrs {:selected true, :inner-text "Clojure"}})
       (option {:attrs {:selected false, :inner-text "OCaml"}})))
     (comp-space nil 16)
     (div {} (textarea {:style ui/textarea, :attrs {:placeholder "Some long text"}})))))

(def comp-widgets-page (create-comp :widget-page init-input update-input render))