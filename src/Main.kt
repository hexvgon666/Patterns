fun main() {
    val student1 = Student(
        id = 1,
        lastName = "Иванов",
        firstName = "Иван",
        patronymic = "Иванович",
        phone = "123456789",
        telegram = "@ivanov_ivan",
        email = "ivanov@example.com",
        git = "ivanov-ivan"
    )

    val student2 = Student(
        id = 2,
        lastName = "Петрова",
        firstName = "Мария",
        patronymic = "Ивановна",
        telegram = "@masha_petrova",
        git = "masha-petrova"
    )

    println(student1)
    println(student2)
}
