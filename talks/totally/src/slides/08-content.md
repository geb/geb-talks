# Content DSL

Reuse FTW

## Content DSL

    class GoogleResultsPage extends Page {
        static content = {
            results { $("li.g") }
            result { i -> results[i] }
            resultLink { i -> result(i).find("a.l", 0) }
            firstResultLink { resultLink(0) }
        }
    }

Content definitions can *build* upon each other.

Content definitions are actually *templates*.

## Optional Content

    class OptionalPage extends Page {
        static content = {
            errorMsg(required: false) { $("p.errorMsg") }
        }
    }

By default, Geb will error if the content you select doesn't exist to support the principle of fail-fast.

The “`required`” option disables this check.

## Dynamic Content

    class DynamicPage extends Page {
        static content = {
            errorMsg(wait: true) { $("p.errorMsg") }
        }
    }

Geb will wait for some time for this content to appear.

By default, it will look for it every 100ms for 5s before giving up. This is highly configurable.

Same semantics as the `waitFor {}` method that can be used anywhere.

## Expensive Content

    class ExpensivePage extends Page {
        static content = {
            results(cache: true) { $("li.results") }
            result { results[it] }
        }
    }

By default, all content is transient.

The `cache` option instructs Geb to hold on to the content, avoiding redundant lookups.

Use carefully, can cause problems with dynamic pages.

## Modules

Modules can be used for reused content fragments.

    class CartInfoModule extends Module {
        static content = {
            section { $("div.cart-info") }
            totalCost { section.find("span.total-cost").toDouble() }
        }
    }

    class HomePage extends Page {
        static content = {
            cartInfo { module CartInfoModule }
        }
    }

## Modules

They encapsulate detail.

    to HomePage
    assert cartInfo.totalCost == 10.00

And support reuse…

    class AnotherPage extends Page {
        static content = {
            cartInfo { module CartInfoModule }
        }
    }
    
## Modules

    <table id="book-results">
      <thead>
        <tr>
          <th>Title</th><th>Author</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Zero History</td><td>William Gibson</td>
        </tr>
        <tr>
          <td>The Evolutionary Void</td><td>Peter F. Hamilton</td>
        </tr>
      </tbody>
    </table>

Modules can be used for repeating content.

## Modules

Modules have a *base*, from which all content lookups are relative.

    class BooksPage extends Page {
      static content = {
        bookResults { 
          moduleList BookRow, $("table#book-results tbody tr") 
        }
      }
    }

    class BookRow extends Module {
      static content = {
        cell { $("td", it) }
        title { cell(0).text() }
        author { cell(1).text() }
      }
    }

## Modules

We now have a model for a row in our table.

    expect: 
    bookResults[0].title == "Zero History" 
    bookResults[1].author == "Peter F. Hamilton

Can be used for any reused/repeating content.

**Note:** talking about domain objects, not HTML tables and rows.

## Inheritance

Pages (and modules) can be arranged in inheritance hierarchies.

    class Footer extends Module {
        static content = {
            copyright { $("p.copyright") }
        }
    }
    class StandardPage extends Page {
        static content = {
            footer { module Footer }
        }
    }
    class FrontPage extends StandardPage {}

The front page will *inherit* the “footer” content definition.
