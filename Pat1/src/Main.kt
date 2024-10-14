fun main() {
    val student1 = Student.Builder(1, "Иванов", "Иван", "Иванович")
        .phone("123456789")
        .email("ivan@mail.com")
        .build()

    val student2 = Student.Builder(2, "Петров", "Петр", "Петрович")
        .telegram("@petr")
        .git("github.com/petr")
        .build()

    println(student1)
    println(student2)
}
