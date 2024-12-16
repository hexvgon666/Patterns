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
    }
}