# update-tags

A ClojureScript nodejs script designed to update the tags for a specific source file in an existing tagfile (creating it if it doesn't exist already)

## Usage

To update the ctags file '<tags-file>' with tags from '<src-file>'

  update-tags <tag-file> <src-file>

Having said that, I can't imagine why you'd want to do that. I plan to use it like this in my .vimrc

  autocmd BufWritePost * execute "silent !update-tags ./.tags % &" | redraw!

...although I've not tried it yet!



## License

Copyright © 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
