
(ns respo-ui.common)

(defn init-input [& args] "")

(defn update-input [state text] text)

(defn on-input [mutate!] (fn [e dispatch!] (mutate! (:value e))))
