#language: en

  Feature: Avito search

    Scenario Outline: Find and print to the console the price value of the first N products

      When Follow the link Avito
      Then Select category <category>
      Then In the search field write <stringForSearch>
      Then Click on the dropdown list of regions
      Then Enter region <city>
      Then Click on the button Show N ads
      Then Activate the checkbox With photo only
      Then Select <sort> in the sort drop-down list
      Then Output to the console Price value of the first <quantity> goods
      Then Close browser

      Examples:
        | category          | stringForSearch | city        | sort  | quantity |
        | OFFICE_EQUIPMENT  | PRINTER         | VLADIVOSTOK | DEAR  | 10       |
        | PRODUCTS_COMPUTER  | MONITOR         | IRKUTSK     | CHEAP | 7        |

