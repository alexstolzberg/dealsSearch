package com.target.targetcasestudy.data

/**
 * Canned data used for testing
 */
object StaticData {
    val deals: List<DealItem> = listOf(
        DealItem(
            id = 0,
            title = "Product 1",
            description = "This is product number 1",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 2",
            description = "This is product number 2",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 3",
            description = "This is product number 3",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 4",
            description = "This is product number 4",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 5",
            description = "This is product number 5",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 6",
            description = "This is product number 6",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 7",
            description = "This is product number 7",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 8",
            description = "This is product number 8",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 9",
            description = "This is product number 9",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        ),
        DealItem(
            id = 0,
            title = "Product 10",
            description = "This is product number 10",
            regularPrice = PriceInfo(
                centsAmount = 1099,
                currencySymbol = "$",
                displayString = "$10.99"
            ),
            aisle = "a1",
            imageUrl = "www.image.com",
            salePrice = null
        )
    )

    val dealsResponse: DealsResponse = DealsResponse(products = deals)
}