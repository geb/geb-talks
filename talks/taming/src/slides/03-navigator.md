# Navigator API

jQuery inspired content selection/interaction

## The $() method

Returns a [Navigator](http://www.gebish.org/manual/current/api/geb-core/geb/navigator/Navigator.html) object.

General format:

    $(«css selector», «index/range», «attribute/text matchers»)

Examples:

    $("div") // all divs
    $("div", 0) // first div
    $("div", 0..2) // first three divs

    // The third section heading with text “Geb”
    $("h2", 2, id: "section", text: "Geb")

## CSS Selectors

Full CSS3 if the target browser supports it.

    $("div.some-class p:first[title='something']")
    $("ul li a")
    $("table tr:nth-child(2n+1) td")
    $("div#content p:first-child::first-line")

CSS lookups are *fast*.

## Attribute/Text matching

Can match on attribute values:

    //<div foo="bar">
    $("div", foo: "bar")

The “text” attribute is special:

    //<div>foo</div>
    $("div", text: "foo")

Can use Regular Expressions:

    //<div>foo</div>
    $("div", text: ~/f.+/)

## Predicates

Geb supplies some handy predicates:

    $("p", text: startsWith("p"))
    $("p", class: contains("section"))
    $("p", id: endsWith(~/\d/))

There are [more of these](http://www.gebish.org/manual/current/navigator.html#attribute_and_text_matching).

## Relative Content

`$()` returns a [Navigator](http://www.gebish.org/manual/current/api/geb-core/geb/navigator/Navigator.html) that allows you to find relative content.

    $("p").previous()
    $("p").prevAll()
    $("p").next()
    $("p").nextAll()
    $("p").parent()
    $("p").siblings()
    $("div").children()

Most of these methods take selectors, indexes and attribute text/matchers too.

    $("p").nextAll(".listing")

## Form Shortcuts

Syntax sugar for working with form controls.

    when:
    username = "foo"
    password = "bar"
    
Same as:

    when:
    $("[name=username]").value("foo")
    $("[name=password]").value("bar")
    
## Form Shortcuts (cont.)

Can be scoped.

    when:
    $("form.login").with {
        username = "foo"
        password = "bar"
    }
    
Faster and safer.

## Form Shortcuts (cont.)

Works with all types.

    when:
    someSelect = "one of the option values"
    someSelect = "one of the option texts"
    someMultiSelect = ["option1", "option2"]
    someCheckbox = true // or false
    someRadioGroup = "The value I want"
    
Same for reading.