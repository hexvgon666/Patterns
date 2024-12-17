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

    //№7,8 чтение из файла
    val students = Student.read_from_txt("C:\\Users\\hexvgon\\IdeaProjects\\Pat1\\src\\read_from.txt")
    for(stud in students)
    {
        println(stud)
    }

    //№9,10 запись в файл
    Student.write_to_txt("write_to.txt", students)

    //Data_table
    val arr = listOf(
        listOf("Мирногов Кирилл Иванович", "kirill-git", "+7-916-123-45-67"),
        listOf("Мишков Иван Витальевич", "Iva-git", "+7-977-111-45-56")
    )
    val datTab = Data_table(arr)
    println("Количество строк ${datTab.GetNumCol()}")
    println("Количество строк ${datTab.GetNumRow()}")
    val col = 0
    val row = 1
    println("Запись на строке $row и столбце $col: ${datTab.GetElem(row,col)}")
    println(datTab)

    //№2.5 класс Data_list_student_short
    val stArr = arrayOf(st)
    val datalist = Data_list_student_short(stArr)
    val dataTable = datalist.get_data()
    println(dataTable)

    //№2.8
    val datalist2 = Data_list_student_short(stArr)

    println("Название полей: ${datalist2.get_names(0)}")

    println("\n Записи")
    val datatab = datalist2.get_data()
    println(datatab)

    //lab 3
    //№3.1
    val stud_listTXT = Student_list_txt("fail.txt")
    val studListTxt = stud_listTXT.readFromFile()
    for(stud_txt in studListTxt)
    {
        println(stud_txt)
    }
        //3.1d
    val col3 = 4
    val row3 = 0

    val arr1 = listOf(
            listOf("Мирногов Кирилл Иванович", "kirill-git", "+7-916-123-45-67"),
            listOf("Мишков Иван Витальевич", "Iva1-git", "+7-977-111-45-56"),
        listOf("Мишков Иван Витальевич", "Iva2-git", "+7-977-111-45-56"),
        listOf("Мишков Иван Витальевич", "Iva3-git", "+7-977-111-45-56")
    )


    // Преобразуем List<List<String>> в List<Student_Short>
    val students3 = arr1.mapIndexed { index, studentData ->
        Student_Short(index, studentData[0], studentData[1], studentData[2])
    }

    // Сортируем студентов по Фамилия и Инициалы (e)
    val sortedStudents = stud_listTXT.sortFIO(students3)

    // d.
    val shortlist = stud_listTXT.get_k_n_student_short_list(row3, col3, sortedStudents)

    for(shortstud in shortlist.data)
    {
        println("Id: ${shortstud.id}, F.I.O: ${shortstud.surnameIn}, Git: ${shortstud.git}, Contact: ${shortstud.contact}")
    }

    // f. Добавить объект класса Student в список (при добавлении сформировать новый ID).

    // Добавляем
    stud_listTXT.addStudent("Мирногов", "Кирилл", "Иванович", "+7-916-123-45-67", "mirno_ivanov", "kirill@example.com", "kirill-git")

    //g. Заменить элемент списка по ID.

    // Заменяем по ID
    val studentToUpdateId = 1
    stud_listTXT.repStudId(studentToUpdateId, "Малахеев", "Кирилл", "Викторович", "+7-916-123-45-67", "mirno_ivanov", "kirill@example.com", "kirill-git")

    //h. Удалить элемент списка по ID.

    // Удаление по ID
    val studentToDeleteId = 1
    stud_listTXT.removeStudent(studentToDeleteId)
    //get_student_short_count Получить количество элементов
    //количество студентов
    println("Количество студентов: ${stud_listTXT.getStudentCount()}")

    //JSON
    val filePath = "C:\\Users\\hexvgon\\IdeaProjects\\Pat1\\src\\JSON.json"
    val studentsList = Students_list_JSON(filePath)
    studentsList.addStudent("Иванов", "Филипп", "Малевович", "+7-988-124-45-55", "ivan2001", "ivan@example.com", "ivan-git")
    val count = studentsList.getStudentCount()
    println("Количество: $count")
    val student = studentsList.getStudentById(1)
    println("Cтудент: $student")
    studentsList.removeStudent(1)
    val newCount = studentsList.getStudentCount()
    println("Количество после удаления: $newCount")

    //YAML
    val studentsYAML = Students_list_YAML("C:\\Users\\hexvgon\\IdeaProjects\\Pat1\\src\\YAML.yaml")
    studentsYAML.addStudent(surname = "Крюкович", name = "Владлен", patronymic = "Киреевич", phone = "+7-988-124-45-55", telegram = "vov_tel", email = "vov@example.com", git = "github.com/vov")
    studentsYAML.addStudent(surname = "Маминов", name = "Имануил", patronymic = "Петрович", phone = "+7-988-124-45-66", telegram = "rov_tel", email = "rov@example.com", git = "github.com/rov")
//    val studentsYAML = listOf(
//        Student(1, "Ivanov", "Ivan", "Ivanovich", "123456789", "ivanov_telegram", "ivanov@example.com", "github.com/ivanov"),
//        Student(2, "Petrov", "Petr", "Petrovich", "987654321", "petrov_telegram", "petrov@example.com", "github.com/petrov")
//    )
//    val objectMapper = ObjectMapper(YAMLFactory())
//    val yamlFile = File("D:\\4_курс\\Libraries\\FileYAML.yaml")
//    // Сериализация данных в YAML
//    objectMapper.writeValue(yamlFile, studentsYAML)
//
//    println("Файл students.yaml успешно создан.")
    val studYAML = studentsYAML.getStudentById(1)
    println("Студент с ID 1: $studYAML")
    studentsYAML.repStudId(1, surname = "Ivanov", name = "Ivan", patronymic = "Ivanovich", phone = "111222333", telegram = "ivanov_updated", email = "ivanov_new@example.com", git = "github.com/ivanov_updated")
    studentsYAML.removeStudent(2)
    println("Количество студентов после удаления: ${studentsYAML.getStudentCount()}")
}