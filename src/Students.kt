class Student(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var patronymic: String,
    private var phone: String? = null,
    private var telegram: String? = null,
    private var email: String? = null,
    private var git: String? = null
) {
    // Геттеры и сеттеры
    class Student(
        id: Int,
        lastName: String,
        firstName: String,
        patronymic: String,
        phone: String? = null,
        telegram: String? = null,
        email: String? = null,
        git: String? = null
    ) {
        private var _id: Int = id
        var id: Int
            get() = _id
            set(value) {
                _id = value
            }

        private var _lastName: String = lastName
        var lastName: String
            get() = _lastName
            set(value) {
                _lastName = value
            }

        private var _firstName: String = firstName
        var firstName: String
            get() = _firstName
            set(value) {
                _firstName = value
            }

        private var _patronymic: String = patronymic
        var patronymic: String
            get() = _patronymic
            set(value) {
                _patronymic = value
            }

        private var _phone: String? = phone
        var phone: String?
            get() = _phone
            set(value) {
                _phone = value
            }

        private var _telegram: String? = telegram
        var telegram: String?
            get() = _telegram
            set(value) {
                _telegram = value
            }

        private var _email: String? = email
        var email: String?
            get() = _email
            set(value) {
                _email = value
            }

        private var _git: String? = git
        var git: String?
            get() = _git
            set(value) {
                _git = value
            }
    }
    override fun toString(): String {
        return "Student(id=$id, fullName='$lastName $firstName $patronymic', phone=$phone, telegram=$telegram, email=$email, git=$git)"
    }
}
