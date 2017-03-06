
(ns respo-ui.comp.colors-page
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style.colors :as colors]
            [respo-ui.style :as ui]))

(def style-palette
  {:width 400,
   :height 40,
   :color "white",
   :margin 16,
   :justify-content "space-around",
   :align-items "center",
   :font-family "Menlo,monospace",
   :font-size 13})

(defn render-palette [title color]
  (div
   {:style (merge ui/row style-palette {:background-color color})}
   (comp-text title nil)
   (comp-text color nil)))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (div {} (comp-text "respo-ui.style.colors" nil))
     (div {} (comp-text "Motif colors" nil))
     (render-palette "motif" colors/motif)
     (render-palette "motif-light" colors/motif-light)
     (render-palette "motif-dark" colors/motif-dark)
     (div {} (comp-text "Functional colors" nil))
     (render-palette "attractive" colors/attractive)
     (render-palette "irreversible" colors/irreversible)
     (render-palette "attentive" colors/attentive)
     (render-palette "verdant" colors/verdant)
     (render-palette "warm" colors/warm)
     (div {} (comp-text "Text colors" nil))
     (render-palette "texture" colors/texture)
     (render-palette "texture-light" colors/texture-light)
     (render-palette "texture-dark" colors/texture-dark)
     (div {} (comp-text "Border colors" nil))
     (render-palette "intersected" colors/intersected)
     (render-palette "intersected-light" colors/intersected-light)
     (div {} (comp-text "Paper colors" nil))
     (render-palette "paper" colors/paper))))

(def comp-colors-page (create-comp :colors-page render))