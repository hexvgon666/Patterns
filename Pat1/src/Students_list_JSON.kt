import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

class Students_list_JSON(filePath: String): Students_list_super(filePath) {
    init {
        objectMapper = ObjectMapper()
        students.addAll(readFromFile())
    }

    override fun readFromFile(): MutableList<Student> {
        return try {
            val file = File(filePath)
            if (file.exists()) {
                objectMapper.readValue(
                    file,
                    objectMapper.typeFactory.constructCollectionType(MutableList::class.java, Student::class.java)
                )
            } else {
                mutableListOf()
            }
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    override fun writeToFile() {
        try {
            objectMapper.writeValue(File(filePath), students)
        } catch (e: Exception) {
            println("Ошибка: ${e.message}")
        }
    }
}
