import kotlin.system.exitProcess

class App {

    val categoryMobile = "Mobile"
    val categoryWeb = "Mobile"
    val courses: MutableList<Course> = mutableListOf(
        Course(
            id = 1,
            name = "Android Development 101",
            category = categoryMobile,
            students = mutableListOf(
                Student(1, "Lin Htet Ko", "linhtetko1518@gmail.com"),
                Student(2, "Mg Mg", "mgmg@gmail.com"),
                Student(3, "Ma Ma", "mama@gmail.com"),
                Student(4, "Hla Hla", "hlahla@gmail.com"),
            )
        ),
        Course(
            id = 2,
            name = "Web Development 101",
            category = categoryWeb,
            students = mutableListOf()
        ),
        Course(
            id = 3,
            name = "Web Development Advanced",
            category = categoryWeb,
            students = mutableListOf()
        ),
        Course(
            id = 4,
            name = "Android Development Advanced",
            category = categoryMobile,
            students = mutableListOf()
        )
    )

    fun start() {
        println(
            """
                ===================
                1. Show Courses
                -------------------
                2. Register Student
                -------------------
                3. Show Students
                -------------------
                4. Exit Program
                ===================
            """.trimIndent()
        )
        print("Please Enter your choice : ")
        when (readln()) {
            "1" -> {
                showCourses()
            }

            "2" -> {
                register()
            }

            "3" -> {
                print("Please enter course id : ")
                val choice = readln().toLong()
                showStudent(choice)
            }

            else -> {
                exitProcess(0)
            }
        }
    }

    private fun showStudent(courseId: Long) {
        val course = courses[(courseId - 1).toInt()]
        for (student in course.students) {
            println("${student.id} -> ${student.name} | ${student.email}")
        }
    }

    private fun showCourses() {
        println(
            """
            ================================
            1. Android Development 101
            --------------------------------
            2. Web Development 101
            --------------------------------
            3. Web Development Advanced
            --------------------------------
            4. Android Development Advanced
            =================================
        """.trimIndent()
        )
        print(
            """
            1. For Register
            2. For Exit Program
            Please enter your choice : 
        """.trimIndent()
        )
        val choice = readln().toInt()
        if (choice == 1) {
            register()
        } else {
            exitProcess(0)
        }
    }

    private fun register() {
        print("Please enter the course id that want to register : ")
        val codeId = readln().toInt()
        print("Please enter student name : ")
        val name: String = readln()
        print("Please enter student email : ")
        val email: String = readln()

        val student = Student(id = System.currentTimeMillis(), name = name, email = email)
        val course = courses[codeId - 1]
        course.students.add(student)
    }
}

fun main() {
    val app = App()
    app.start()
}