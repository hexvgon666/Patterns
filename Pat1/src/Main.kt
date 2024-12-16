fun main() {
    val example_1 = Student(
        1,
        "Фолгимштейн",
        "Федор",
        "Крузинштейн",
        "+7-989-345-34-67",
        "@ROOMdoom",
        "RoomDoom@mail.ru",
        "https://github.com/Fedor"

    )

    val example_2 = Student(
        id = 2,
        surname = "Шаповалова",
        name = "Карина",
        phone = "+7-656-134-67-89"
    )

    val example_3 = Student(
        id = 3,
        surname = "Зайцев",
        name = "Иехонтий",
        email = "zoom@example.com"
    )

    val example_4 = Student(
        id = 4,
        surname = "Смурыгин",
        name = "Яхонт",
        telegram = "@yakhont"
    )


    val example_hashMap = hashMapOf<String, Any?>(
        "id" to 5,
        "surname" to "Фуркин",
        "name" to "Иван",
        "patronymic" to "Степанович",
        "phone" to "+7-987-336-56-89",
        "telegram" to "@samsam",
        "mail" to "ivan@mail.ru"
    )

    val example_validPhone = hashMapOf<String, Any?>(
        "id" to 6,
        "surname" to "Кирсанов",
        "name" to "Сергей",
        "patronymic" to "Генадьевич",
        "phone" to "+7-916-123-45-67", // Корректный номер
        "telegram" to "ivan_ivanov",
        "mail" to "ivan@example.com",
        "git" to "ivan_git"
    )
    val validPhone = Student(example_validPhone)

    val valid = Student(
        id = 4,
        surname = "Смурыгин",
        name = "Яхонт",
        git = "https://github.com/Smyrk"
    )



    valid.setContacts(phone = "+7-916-123-45-69", telegram = "johndoe", mail = "sdfasf@mail.ru")

    valid.phone="+7-916-123-45-67";

    println(valid)

    // Проверяем валидность данных после установки контактов
    val isValid = valid.validate()
    println("Данные студента валидны: $isValid")


    println(example_1)
    println(example_2)
    println(example_3)
    println(example_4)

    val hash = Student(example_hashMap)
    println(hash)
    println(validPhone)

//lab2
    // Пример строки для парсинга
    val studentData = "7 Мирногов Кирилл Иванович +7-916-136-45-67 mirno_ivanov kirill@example.com kirill-git"
    // Создание объекта Student с использованием нового конструктора
    val stud = Student(studentData)
    // Вывод результата
    println(stud)
    //№3 метод getInfo
    println(stud.getInfo())

    //№4 класс Student_short
    var st = Student_Short(stud)
    println(st)

    //№7 чтение из файла
    val students = Student.read_from_txt("C:\\Users\\hexvgon\\IdeaProjects\\Pat1\\src\\read_from.txt")
    for(stud in students)
    {
        println(stud)
    }
}