class Student_list_txt: Student(0, "", ""){
    companion object{
        fun read_from_txt(filePath: String): List<Student>
        {
            return Student.read_from_txt(filePath)
        }
        fun write_to_txt(filePath: String, stud: List<Student>)
        {
            return Student.write_to_txt(filePath,stud)
        }

        //3.1c Получить объект класса Student по ID
        fun getStudentId(id:Int,filePath: String):Student?
        {
            var arr = read_from_txt(filePath)
            for(arra in arr)
            {
                if(arra.id == id)
                {
                    return arra
                }
            }
            return null
        }
        //3.1d
        fun get_k_n_student_short_list(n: Int, k: Int, students: List<Student_Short>): Data_list_student_short {
            require(n >= 0) { "Индекс n должен быть положительным или равен 0" }
            require(k > 0) { "Индекс k должен быть положительным или равен 0" }
            return Data_list_student_short(students
                .drop(n) // Пропускаем первые n элементов
                .take(k) // Берём следующие k элементов
                .toTypedArray()
            )
        }

        // сортировка по ФИО
        fun sortFIO(students: List<Student_Short>): List<Student_Short> {
            return students.sortedWith(compareBy({ it.surnameIn }))
        }

        //
        private val students: MutableList<Student> = mutableListOf() // Список студентов
        // f Функция добавления нового студента
        fun addStudent(surname: String, name: String, patronymic: String?, phone: String?, telegram: String?, email: String?, git: String?) {
            val newId = if (students.isEmpty()) 1 else students.last().id + 1 // Генерация нового ID
            val newStudent = Student(newId, surname, name, patronymic, phone, telegram, email, git)
            students.add(newStudent)
            println("Добавлен: $newStudent")
        }
        // g Функция замены студента по ID
        fun repStudId(id: Int,surname: String, name: String, patronymic: String?, phone: String?, telegram: String?, email: String?, git: String?): Boolean {
            val index = students.indexOfFirst { it.id == id }
            return if (index != -1) {
                // Заменяем студента на новый с тем же ID
                students[index] = Student(id, surname, name, patronymic, phone, telegram, email, git)
                println("Студент с ID $id был обновлён.")
                true
            } else {
                println("Студент с ID $id не найден.")
                false
            }
        }
        // h Функция удаления студента по ID
        fun removeStudent(id: Int): Boolean {
            val index = students.indexOfFirst { it.id == id }
            return if (index != -1) {
                students.removeAt(index)
                println("Студент с ID $id был удален.")
                true
            } else {
                println("Студент с ID $id не найден.")
                false
            }
        }
        // i Функция получения количества студентов
        fun getStudentShortCount(): Int {
            return students.size
        }
    }
}