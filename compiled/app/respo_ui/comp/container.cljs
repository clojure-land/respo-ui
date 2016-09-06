
(ns respo-ui.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span input]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.common :refer [init-input
                                     update-input on-input]]))

(defn render [store]
  (fn [state mutate!]
    (div
      {:style (merge ui/fullscreen ui/global ui/card)}
      (div
        {:style ui/row-center}
        (div {:style ui/button} (comp-text "save" nil))
        (comp-space "8px" nil)
        (div {:style ui/button} (comp-text "cancel" nil)))
      (comp-space nil "16px")
      (div
        {:style ui/row-center}
        (input
          {:style ui/input,
           :event {:input (on-input mutate!)},
           :attrs {:placeholder "input"}})
        (comp-text state nil)))))

(def comp-container
 (create-comp :container init-input update-input render))
