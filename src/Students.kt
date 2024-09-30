class Student(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val patronymic: String,
    var phone: String? = null,
    var telegram: String? = null,
    var email: String? = null,
    var git: String? = null
) {
    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        patronymic: String
    ) : this(id, lastName, firstName, patronymic, null, null, null, null)

    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        patronymic: String,
        phone: String
    ) : this(id, lastName, firstName, patronymic, phone, null, null, null)

    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        patronymic: String,
        phone: String,
        telegram: String
    ) : this(id, lastName, firstName, patronymic, phone, telegram, null, null)

    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        patronymic: String,
        phone: String,
        telegram: String,
        email: String
    ) : this(id, lastName, firstName, patronymic, phone, telegram, email, null)

    override fun toString(): String {
        return "Student(id=$id, fullName='$lastName $firstName $patronymic', phone=$phone, telegram=$telegram, email=$email, git=$git)"
    }
}
