import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type
class Students_list_JSON(private val filePath: String) {
    private val gson = Gson()
    private val students: MutableList<Student> = readFromJson()

    private fun readFromJson(): MutableList<Student> {
        return try {
            val jsonString = File(filePath).readText()
            val listType: Type = object : TypeToken<MutableList<Student>>() {}.type
            gson.fromJson(jsonString, listType)
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    private fun writeToJson() {
        val jsonString = gson.toJson(students)
        File(filePath).writeText(jsonString)
    }

    fun addStudent(surname: String, name: String, patronymic: String?, phone: String?, telegram: String?, email: String?, git: String?) {
        val newId = if (students.isEmpty()) 1 else students.last().id + 1
        val newStudent = Student(newId, surname, name, patronymic, phone, telegram, email, git)
        students.add(newStudent)
        writeToJson()
        println("Добавлен: $newStudent")
    }

    fun repStudId(id: Int, surname: String, name: String, patronymic: String?, phone: String?, telegram: String?, email: String?, git: String?): Boolean {
        val index = students.indexOfFirst { it.id == id }
        return if (index != -1) {
            students[index] = Student(id, surname, name, patronymic, phone, telegram, email, git)
            writeToJson()
            println("Студент с ID $id был обновлён.")
            true
        } else {
            println("Студент с ID $id не найден.")
            false
        }
    }

    fun removeStudent(id: Int): Boolean {
        val index = students.indexOfFirst { it.id == id }
        return if (index != -1) {
            students.removeAt(index)
            writeToJson()
            println("Студент с ID $id был удален.")
            true
        } else {
            println("Студент с ID $id не найден.")
            false
        }
    }

    fun getStudentCount(): Int {
        return students.size
    }

    fun getStudentById(id: Int): Student? {
        return students.find { it.id == id }
    }
}