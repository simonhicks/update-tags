# update-tags

A ClojureScript nodejs script designed to update the tags for a specific source file in an
existing tagfile (creating it if it doesn't exist already). Since `ctags -a` blindly appends
without deleting old tags, this script removes the old tags using nodejs before calling
`ctags -a`

## Usage

To update the ctags file '<tags-file>' with tags from '<src-file>'

    update-tags <tag-file> <src-file>

Having said that, I can't imagine why you'd want to do that. I use it in my .vimrc like this

    autocmd BufWritePost * silent execute "!update-tags ./.tags % &" | redraw!

...which auto-updates the .tags file whever you save

## TODO

- currently you have to open and write the file to get the tags. They should be auto-generated on vim start
- recursively search for tag file if the file isn't given as a param

## License

Copyright © 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
