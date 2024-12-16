class Data_list_student_short(studlist: Array<Student_Short>): Data_list<Student_Short>(studlist)
{
    override fun get_names(id: Int): Data_table
    {
        val names = arrayOf("ID", "F.I.O", "Git", "Contact")
        return Data_table(listOf(names.asList()))
    }
    override fun get_data(): Data_table {
        val attr = mutableListOf<MutableList<Any>>() // Список, который мы будем преобразовывать в DataTable
        var count = 1
        for (str in data) {
            // Сформируйте запись для строки с данными
            attr.add(mutableListOf(count, str.surnameIn?:"Нет данных", str.git?:"Нет данных", str.contact?:"Нет данных"))
            count++
        }
        // Возвращаем DataTable, сформированная из списка attr
        return Data_table(attr)
    }
}