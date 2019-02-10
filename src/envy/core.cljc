(ns envy.core
  #?(:cljs (:require-macros [envy.core]))
  #?(:clj (:require [cljs.env :as env])))

#?(:clj
    (defn get-env []
      (-> env/*compiler*
          (or (atom nil))
          deref
          :options
          :closure-defines
          (get "env")
          clojure.edn/read-string)))

#?(:clj
    (defmacro get-env-macro []
      `(do ~(get-env))))

#?(:cljs
    (def env (envy.core/get-env-macro)))
