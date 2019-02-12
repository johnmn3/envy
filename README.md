# envy
`envy` smooths over the importing of `:closure-defines` data from a ClojureScript project's `cljs.edn` file into an `env` var that you can use at runtime.

For instance, if we had the following in our `cljs.edn` file:
```clojure
{
...
 :closure-defines
 {env
  "{:my.thing/instrument? true
    :server               \"localhost\"
    :port                 9999}"}
...
```
Then in a REPL we would be able to do `(-> envy.core/env :my.thing/instrument?)` and get back `true`.

### Usage
Let's first clone the repo and launch a REPL:
```bash
git clone https://github.com/johnmn3/envy.git
cd envy
```
Edit the `cljs.edn` file to look like the above example. Then launch your REPL:
```bash
clj -m cljs.main -co co.edn -r
```

Now, in the REPL, let's require `envy.core` and try out `env`:
```clojure
cljs.user=> (require 'envy.core)
nil
cljs.user=> envy.core/env
{:my.thing/instrument? true, :server "localhost", :port 9999}
```

### License
Copyright © 2019 John M. Newman III

Distributed under the Eclipse Public License either version 2.0 or (at your option) any later version.
