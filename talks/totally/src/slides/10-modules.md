# Modules

Reusable fragments

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
            cartInfo { module(CartInfoModule) }
        }
    }

## Modules

They encapsulate detail.

    to HomePage
    assert cartInfo.totalCost == 10.00

And support reuse…

    class AnotherPage extends Page {
        static content = {
            cartInfo { module(CartInfoModule) }
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
          moduleList(BookRow, $("table#book-results tbody tr"))
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
