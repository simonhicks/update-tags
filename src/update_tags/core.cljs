#!/usr/bin/env node
(ns update_tags.core
  (:require [cljs.nodejs :as node]
            [clojure.string :as s]))

(declare ^:dynamic *tag-file*)
(declare ^:dynamic *src-file*)

(def fs (node/require "fs"))
(def exec (.-exec (node/require "child_process")))
(def ctags-opts (.-CTAGS (.-env node/process)))

(defn- tag-file-lines []
  (s/split-lines (.readFileSync fs *tag-file*)))

(defn- matches-src-file
  "Returns the string argument if it matches *src-file*. nil otherwise"
  [string]
  (re-find (re-pattern *src-file*) string))

(defn- remove-old-lines [lines]
  (filter (comp not matches-src-file) lines))

(defn- write-to-tag-file [lines]
  (->> lines (s/join "\n") (.writeFileSync fs *tag-file*)))

(defn- remove-old-tags []
  (-> (tag-file-lines) remove-old-lines write-to-tag-file))

(defn- update-tag-file []
  (let [cmd (str "ctags -a -f " *tag-file* " " ctags-opts " " *src-file*)]
    (exec cmd)))

(defn start [tag-file src-file & _]
  (let [valid-args (and tag-file src-file)]
    (if valid-args
      (binding [*tag-file* tag-file
                *src-file* src-file]
        (when (.existsSync fs *tag-file*)
          (remove-old-tags))
        (update-tag-file))
      (println "USAGE: update-tags <tag-file> <src-file>"))))

(set! *main-cli-fn* start)
