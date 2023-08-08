import kotlin.system.exitProcess

fun main() {

    showProgramFeature()

    //User Input
    print("Please enter your choice : ")
    val userInput = readln()

    when (userInput) {
        "1" -> {
            var totalPrice = 0

            do {

                showAvailableProducts()
                val productCode = inputProductCode()

                val productPrice = retrieveProductPrice(productCode)

                print("Please enter product quantity : ")
                val quantity = readln().toInt()

                totalPrice += calculateTotalPrice(price = productPrice, quantity = quantity)

                print("Do you want to remove some items? Say 'y' or If not, 'n'")
                val confirmation = readln()
                if (confirmation == "y") {
                    val pCode = inputProductCode()

                    val pPrice = retrieveProductPrice(pCode)

                    totalPrice -= pPrice
                }

                print("Total Price $totalPrice")

                print("Please enter 1 for continue or 0 to exit")
                val isContinue = readln()

            } while (isContinue == "1")
        }

        "2" -> {
            print("Enter product code : ")
            val productCode = readln()

            val productPrice = retrieveProductPrice(productCode)
            var totalPrice = 0
            totalPrice += calculateTotalPrice(productPrice)
            print("Total Price $totalPrice")
        }

        "3" -> {
            exitProcess(0)
        }
    }
}

fun showAvailableProducts() {
    val content = """
                =================================
                Code        Name            Price
                =================================
                0001        GM Cake         2600
                0002        GM Bread        500
                0003        Bean Milk       1300
                0004        Cocala          800
                0005        Coffee mix      300
                0006        Max plus        800
                ================================
            """.trimIndent()
    println(content)
}

fun showProgramFeature() {
    // program features
    println(

        """
            -------------------------------
            No          Features
            -------------------------------
            1           Show Product List 
            2           Instant Pay
            3           Exit Program
            --------------------------------
        """.trimIndent()

        // Product လက်ကျန်စစ်ရန်
    )
}

fun inputProductCode(): String {
    print("Please enter product code : ")
    return readln()
}

fun retrieveProductPrice(productCode: String) = when (productCode) {
    "0001" -> 2600
    "0002" -> 500
    "0003" -> 1300
    "0004" -> 800
    "0005" -> 300
    "0006" -> 800
    else -> 0
}

fun calculateTotalPrice(price: Int, quantity: Int = 1) = price.times(quantity)
