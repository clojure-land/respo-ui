
(ns respo-ui.comp.navbar
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [respo-ui.colors :as colors]))

(def style-container
  (merge
   ui/row
   {:background-color colors/motif,
    :width "100%",
    :height 48,
    :align-items "center",
    :padding "0 16px",
    :color "white",
    :font-size 24,
    :font-weight 300,
    :font-family "Josefin Sans"}))

(defcomp comp-navbar () (div {:style style-container} (<> "Respo UI")))
