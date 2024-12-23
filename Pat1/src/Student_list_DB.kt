import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
class Students_list_DB private constructor() {
    private val url = "jdbc:postgresql://localhost:5433/Students"
    private val user = "postgres"
    private val password = "123"

    companion object {

        private val instance: Students_list_DB = Students_list_DB()
        fun getInstance(): Students_list_DB {
            return instance
            }
        }


    fun getStudentById(id: Int): Student? {
        var student: Student? = null
        val query = "SELECT * FROM student WHERE id = ?"
        val conn = DriverManager.getConnection(url, user, password)
        val pstmt = conn.prepareStatement(query)
        try {
            pstmt.setInt(1, id)  // Óñòàíîâêà ïàðàìåòðà çàïðîñà
            val rs = pstmt.executeQuery()
            if (rs.next()) {
                val studentId = rs.getInt("id")
                val surname = rs.getString("surname")
                val name = rs.getString("name")
                val patronymic = rs.getString("patronymic")
                val phone = rs.getString("phone")
                val telegram = rs.getString("telegram")
                val email = rs.getString("email")
                val git = rs.getString("git")
                student = Student(studentId, surname, name, patronymic, phone, telegram, email, git)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            pstmt.close() // Çàêðûâàåì PreparedStatement
            conn.close()  // Çàêðûâàåì ñîåäèíåíèå
        }
        return student
    }

    fun get_k_n_student_short_list(k: Int, n: Int): MutableList<Student_Short> {
        val query = "SELECT id, surname, name, patronymic, phone, telegram, email, git FROM student ORDER BY id LIMIT ? OFFSET ?"
        val studentList = mutableListOf<Student_Short>()
        val conn = DriverManager.getConnection(url, user, password)
        val pstmt = conn.prepareStatement(query)

        return try {
            pstmt.setInt(1, n)  // Óñòàíîâêà LIMIT
            pstmt.setInt(2, k)  // Óñòàíîâêà OFFSET
            val rs = pstmt.executeQuery()
            while (rs.next()) {
                val id = rs.getInt("id")
                val surname = rs.getString("surname")
                val name = rs.getString("name")
                val patronymic = rs.getString("patronymic")
                val phone = rs.getString("phone")
                val telegram = rs.getString("telegram")
                val email = rs.getString("email")
                val git = rs.getString("git")
                studentList.add(Student_Short(id, surname + name + patronymic, git, phone + telegram + email))
            }
            studentList  // Âîçâðàùàåì èòîãîâûé ñïèñîê ñòóäåíòîâ
        } catch (e: Exception) {
            e.printStackTrace()
            mutableListOf()  // Âîçâðàùàåì ïóñòîé ñïèñîê â ñëó÷àå îøèáêè
        } finally {
            pstmt.close() // Çàêðûâàåì PreparedStatement
            conn.close() // Çàêðûâàåì ñîåäèíåíèå
        }
    }
    fun addStudent(student: Student): Boolean {
        val query = "INSERT INTO student (surname, name, patronymic, phone, telegram, email, git) VALUES (?, ?, ?, ?, ?, ?, ?)"
        val conn = DriverManager.getConnection(url, user, password)
        val pstmt = conn.prepareStatement(query)
        return try {
            pstmt.setString(1, student.surname)
            pstmt.setString(2, student.name)
            pstmt.setString(3, student.patronymic)
            pstmt.setString(4, student.phone)
            pstmt.setString(5, student.telegram)
            pstmt.setString(6, student.email)
            pstmt.setString(7, student.git)
            pstmt.executeUpdate() > 0 // true, åñëè ñòðîêè áûëè èçìåíåíû
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            pstmt.close() // Çàêðûâàåì PreparedStatement
            conn.close() // Çàêðûâàåì ñîåäèíåíèå
        }
    }


    fun updateStudent(student: Student): Boolean {
        val query = "UPDATE student SET surname = ?, name = ?, patronymic = ?, phone = ?, telegram = ?, email = ?, git = ? WHERE id = ?"
        val conn = DriverManager.getConnection(url, user, password)
        val pstmt = conn.prepareStatement(query)
        return try {
            pstmt.setString(1, student.surname)
            pstmt.setString(2, student.name)
            pstmt.setString(3, student.patronymic)
            pstmt.setString(4, student.phone)
            pstmt.setString(5, student.telegram)
            pstmt.setString(6, student.email)
            pstmt.setString(7, student.git)
            pstmt.setInt(8, student.id) // Óñòàíîâêà ID äëÿ ïîèñêà
            pstmt.executeUpdate() > 0 // Âîçâðàùàåò true, åñëè ñòðîêè áûëè îáíîâëåíû
        } catch (e: Exception) {
            e.printStackTrace()
            false // Âîçâðàùàåò false â ñëó÷àå îøèáêè
        } finally {
            pstmt.close() // Çàêðûâàåì PreparedStatement
            conn.close() // Çàêðûâàåì ñîåäèíåíèå
        }
    }
    fun deleteStudent(studentId: Int): Boolean {
        val query = "DELETE FROM student WHERE id = ?"
        val conn = DriverManager.getConnection(url, user, password)
        val pstmt = conn.prepareStatement(query)
        return try {
            pstmt.setInt(1, studentId)
            pstmt.executeUpdate() > 0 // true, åñëè ñòðîêè áûëè óäàëåíû
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            pstmt.close() // Çàêðûâàåì PreparedStatement
            conn.close() // Çàêðûâàåì ñîåäèíåíèå
        }
    }
    fun getStudentCount(): Int {
        val query = "SELECT COUNT(*) FROM student"
        val conn = DriverManager.getConnection(url, user, password)
        val pstmt = conn.prepareStatement(query)
        return try {
            val rs = pstmt.executeQuery()
            if (rs.next()) {
                rs.getInt(1)
            } else {
                0 // åñëè èõ íåò, âîçâðàùàåì 0
            }
        } catch (e: Exception) {
            e.printStackTrace()
            0 // îøèáêè = 0
        } finally {
            pstmt.close() // Çàêðûâàåì PreparedStatement
            conn.close() // Çàêðûâàåì ñîåäèíåíèå
        }
    }
    }