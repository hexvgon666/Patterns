import java.io.File
import java.io.FileNotFoundException
open class Student(
    id: Int,
    surname: String,
    name: String,
    patronymic: String? = null,
    phone: String? = null,
    telegram: String? = null,
    email: String? = null,
    git: String? = null
) : Student_Super(id, git) {

    var surname: String = surname
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var name: String = name
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var patronymic: String? = patronymic
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var phone: String? = phone
        get() {
            return field
        }
        set(value) {
            checkPhone(value)
            field = value
        }
    var telegram: String? = telegram
        get() {
            return field
        }
        set(value) {
            checkTelegram(value)
            field = value
        }
    var email: String? = email
        get() {
            return field
        }
        set(value) {
            checkMail(value)
            field = value
        }


    //lab2 метод getInfo 3 задание
    fun getInfo(): String
    {
        var field = "Ф.И.О. " + getSHName()
        field += " " + getContact()
        field += " " + getSHGIT()
        return field
    }
    fun getSHName(): String
    {
        var field = surname + " " + name + " " + patronymic
        return field
    }
    fun getSHGIT(): String
    {
        if(!git.isNullOrEmpty())
        {
            return "GIT: " + git
        }
        return "Ошибка GIT"
    }
    fun getContact(): String
    {
        if(!phone.isNullOrEmpty())
        {
            return "Телефон: " + phone
        }
        if(!telegram.isNullOrEmpty())
        {
            return "Телеграм: " + telegram
        }
        if(!email.isNullOrEmpty())
        {
            return "Email: " + email
        }
        return "Ошибка нет контактов "
    }
    // Первичный конструктор, который принимает обязательные поля
    init {
        counter ++
        require(surname.isNotBlank()) { "Фамилия не может быть пустой" }
        require(name.isNotBlank()) { "Имя не может быть пустым" }
        //checkPhone(phone)
    }

    // Вторичные конструкторы для создания объектов с различными комбинациями
    constructor(
        id: Int,
        surname: String,
        name: String,
        phone: String? = null,
        telegram: String? = null,
        email: String? = null,
        git: String? = null
    ) : this(id, surname, name, null, phone, telegram, email, git)

    //    constructor(_id:Int,_lastname:String,_name:String,_fathername:String,_phone:String?=null,_telegram:String?=null,_mail:String?=null,_git:String?=null)
//    {
//        id=_id
//        surname=_lastname
//        name=_name
//        patronymic=_fathername
//        phone=_phone
//        telegram=_telegram
//        email=_mail
//        git=_git
//    }
    // Вторичный конструктор, который принимает HashMap
    constructor(hashStud: HashMap<String, Any?>) : this(
        (hashStud["id"] as? Int) ?: throw IllegalArgumentException("ID обязателен"),
        (hashStud["surname"] as? String) ?: throw IllegalArgumentException("Фамилия обязательна"),
        (hashStud["name"] as? String) ?: throw IllegalArgumentException("Имя обязательно"),
        (hashStud["patronymic"] as? String) ?: "",
        (hashStud["phone"] as? String)?.also { checkPhone(it) },
        hashStud["telegram"]?.toString(),
        hashStud["email"]?.toString(),
        hashStud["git"]?.toString()
    )

    companion object {
        var counter = 0
        fun ValidPhone(phone: String?): Boolean {
            return phone?.matches(Regex("^\\+\\d{1,3}(-\\d{3}){2}-\\d{2}-\\d{2}\$")) ?: false
        }

        // Метод проверки имени пользователя Telegram
        fun ValidTelegram(telegram: String?): Boolean {
            return telegram?.matches(Regex("^[a-zA-Z0-9_]{5,32}\$")) ?: false
        }

        // Метод проверки формата электронной почты
        fun ValidMail(mail: String?): Boolean {
            return mail?.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")) ?: false
        }

        // Метод проверки формата Git URL
        fun ValidGit(git: String?): Boolean {
            return git?.matches(Regex("^[a-zA-Z0-9-_]+/[a-zA-Z0-9-_]+$")) ?: false
        }


        // Метод проверки номера телефона с выбрасыванием исключения
        internal fun checkPhone(phone: String?) {
            if (!ValidPhone(phone)) {
                throw IllegalArgumentException("Неправильный формат телефонного номера")
            }
        }

        // Метод проверки Telegram с выбрасыванием исключения
        internal fun checkTelegram(telegram: String?) {
            if (!ValidTelegram(telegram)) {
                throw IllegalArgumentException("Неправильный формат Telegram ")
            }
        }

        // Метод проверки электронной почты с выбрасыванием исключения
        internal fun checkMail(mail: String?) {
            if (!ValidMail(mail)) {
                throw IllegalArgumentException("Неправильный формат электронной почты")
            }
        }

        // Метод проверки Git с выбрасыванием исключения
        internal fun checkGit(git: String?) {
            if (!ValidGit(git)) {
                throw IllegalArgumentException("Неправильный формат Git")
            }
        }
        // Метод проверки файла
        fun read_from_txt(filePath: String): List<Student> {

            var stud = mutableListOf<Student>()

            try {
                val file = File(filePath)

                // Проверяем, существует ли файл
                if (!file.exists()) {
                    println("Файл с указанным адресом не найден: $filePath")
                    return stud // Возвращаем пустой список
                }

                // Считываем данные из файла и создаем объекты Student
                var line = file.readLines()

                try {
                    for(lines in line)
                    {
                        val student = Student(lines)
                        stud.add(student)
                    }
                } catch (e: Exception) {
                    println("Ошибка при создании студента из строки: \"$line\". Причина: ${e.message}")
                }
            } catch (e: Exception) {
                println("Ошибка при чтении файла: ${e.message}")
            }

            return stud // Возвращаем список студентов
        }

        fun write_to_txt(filePath: String, stud: List<Student>) {
            try {
                val file = File(filePath)
                var text = ""
                for (student in stud) {
                    text += (student.toString() + "\n")
                }
                file.writeText(text)
                println("Данные записаны в файл: $filePath")
            } catch (e: Exception) {
                println("Ошибка при записи в файл: ${e.message}")
            }
        }
    }



    // Метод для проверки наличия Git
    private fun validateGit(): Boolean {
        return !git.isNullOrEmpty()
    }

    // Метод для проверки наличия любого контакта
    private fun validateContact(): Boolean {
        return !phone.isNullOrEmpty() || !telegram.isNullOrEmpty() || !email.isNullOrEmpty()
    }

    // Основной метод валидации
    fun validate(): Boolean {
        return validateGit() && validateContact()
    }

    // Метод для установки значений контактов
    fun setContacts(phone: String? = null, telegram: String? = null, mail: String? = null) {
        this.phone = phone
        this.telegram = telegram
        this.email = mail
    }

    override fun toString(): String {
        return "Student(ID: $id, Surname: '$surname', Name: '$name', fathername: '${patronymic ?: "NO"}', " +
                "Phone: '${phone ?: "No"}', Telegram: '${telegram ?: "No"}', " +
                "Email: '${email ?: "No"}', GIT: '${git ?: "NO"}')"
    }

//lab2 Парсер строки
    constructor(input: String) : this(
        id = input.split(" ")[0].toInt(),
        surname = input.split(" ")[1],
        name = input.split(" ")[2],
        patronymic = input.split(" ").getOrNull(3),
        phone = input.split(" ").getOrNull(4),
        telegram = input.split(" ").getOrNull(5),
        email = input.split(" ").getOrNull(6),
        git = input.split(" ").getOrNull(7)
    )
}


