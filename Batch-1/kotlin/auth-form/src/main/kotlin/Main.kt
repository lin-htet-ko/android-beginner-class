import java.util.UUID

/*
    {
        "user_id" : {
            "name": "Lin Htet Ko",
            "age": 21,
            "gender": "male",
            "email": "linhtetko1518@gmail.com",
            "nation": "Dawei",
            "address": "Rangoon",
            "spoken_languages": ["Dawei", "Burmese", "English", "Thai"]
        },
        "user_id" : {
            "name": "Lin Htet Ko",
            "age": 21,
            "gender": "male",
            "email": "linhtetko1518@gmail.com",
            "nation": "Dawei",
            "address": "Rangoon",
            "spoken_languages": ["Dawei", "Burmese", "English", "Thai"]
        },
        "user_id" : {
            "name": "Lin Htet Ko",
            "age": 21,
            "gender": "male",
            "email": "linhtetko1518@gmail.com",
            "nation": "Dawei",
            "address": "Rangoon",
            "spoken_languages": ["Dawei", "Burmese", "English", "Thai"]
        },
        ...
    }
 */
fun main() {

    val users = mutableMapOf<String, Map<String, Any>>(
        "abce" to mapOf(
            "name" to "Lin Htet Ko",
            "age" to 100,
            "gender" to "Male",
            "email" to "linhtetko1518@gmail.com",
            "password" to "password",
            "nation" to "nation",
            "address" to "Rangoon",
            "spoken_languages" to listOf("Dawei", "Burmese")
        )
    )

    val authCategory = authForm()
    if (authCategory == 1) {
        val isLoginSuccess = login(users)
        if (isLoginSuccess){
            printWithDecoration("Success")
        }else{
            printWithDecoration("Something Wrong")
        }
    } else if (authCategory == 2) {
        val user = register().toMutableMap()

        val id = UUID.randomUUID().toString()
        user["id"] = id

        users[id] = user

        printWithDecoration("Register Successfully")
    }
}

fun authForm(): Int {
    val content = """
        =========================
        =   * Login -> 1        =
        =   * Register -> 2     =
        =========================
    """.trimIndent()

    println(content)
    print("Please enter auth category : ")
    return readln().toInt()
}

fun formField(label: String, message: String = ""): Any {
    if (message.isNotEmpty()) {
        println(message)
    }
    print("$label : ")
    return readln()
}

fun register(): Map<String, Any> {

    val name = formField("Name")
    val age = formField("Age")
    val gender = formField("Gender")
    val email = formField("Email")
    val password = formField("Email")
    val nation = formField("Nation")
    val address = formField("Address")
    val spokenLanguages = (formField(
        label = "Spoken Languages",
        message = "*** Please enter spoken languages by splitting comma ***"
    ) as String).split(",")

    return mapOf(
        "name" to name,
        "age" to age,
        "gender" to gender,
        "email" to email,
        "password" to password,
        "nation" to nation,
        "address" to address,
        "spoken_languages" to spokenLanguages
    )
}

fun login(users: Map<String, Map<String, Any>>): Boolean{
    val email = formField("Email")
    val password = formField("Password")

    var isLoginSuccess: Boolean = false
    for ((_,user) in users){
        if (email == user["email"] && password == user["password"]) {
            isLoginSuccess = true
            break
        }
    }
    return isLoginSuccess
}

fun printWithDecoration(message: String){
    val size = message.length + 8
    var decoration = ""
    for (i in 0 .. size){
        decoration += "="
    }

    println(decoration)
    println("=   $message   =")
    println(decoration)
}