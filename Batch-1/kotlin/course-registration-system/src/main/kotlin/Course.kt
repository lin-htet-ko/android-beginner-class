class Course(
    val id: Long,
    val name: String,
    val category: String,
    val students: MutableList<Student>
)