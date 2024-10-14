class Student private constructor(
        val id: Int,
        val lastName: String,
        val firstName: String,
        val patronymic: String,
        val phone: String? = null,
        val telegram: String? = null,
        val email: String? = null,
        val git: String? = null
) {
    // Статический билдера
    class Builder(val id: Int, val lastName: String, val firstName: String, val patronymic: String) {
        private var phone: String? = null
        private var telegram: String? = null
        private var email: String? = null
        private var git: String? = null

        fun phone(phone: String?) = apply { this.phone = phone }
        fun telegram(telegram: String?) = apply { this.telegram = telegram }
        fun email(email: String?) = apply { this.email = email }
        fun git(git: String?) = apply { this.git = git }

        fun build(): Student {
            return Student(id, lastName, firstName, patronymic, phone, telegram, email, git)
        }
    }

    override fun toString(): String {
        return "Student(id=$id, fullName='$lastName $firstName $patronymic', phone=$phone, telegram=$telegram, email=$email, git=$git)"
    }
}

