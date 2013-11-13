# Modules

Reusable fragments

## Modules

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
