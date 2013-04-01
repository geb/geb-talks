# jQuery

[http://jquery.com/](http://jquery.com/)

## jQuery - write more, do less

jQuery provides an incredibly powerful API for navigating and selecting content.

    $("div#footer").prev().children();

CSS based, a whole lot better than XPath.

## Geb's inspiration

Geb features a “Navigator API” that is inspired by jQuery.

    // This is Geb code, not jQuery JavaScript…
    
    $("h1").previous().children()

API is not identical.

## jQuery “features”

1. CSS based content lookup
2. A jQuery object represents one or more nodes
3. Methods for getting content relative to other content
4. Chaining, or fluent API

Geb doesn't aim to emulate jQuery, it just borrows ideas.