(defproject update-tags "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :plugins [[lein-cljsbuild "0.2.10"]]
  :dependencies [[org.clojure/clojure "1.4.0"]]

  :cljsbuild {:builds [{:builds nil
                        :source-path "src"
                        :compiler {:target :nodejs
                                   :output-to "bin/update-tags"
                                   :optimizations :simple}}]})
