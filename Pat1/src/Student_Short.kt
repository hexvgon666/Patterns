class Student_Short (
    id: Int,
    surnameIN: String? = null,
    git: String? = null,
    contact: String? = null
) : Student_Super(id, git) {

    var surnameIn: String? = surnameIN
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var contact: String? = contact
        get() {
            return field
        }
        set(value) {
            field = value
        }
    constructor(id: Int, input: String) : this(
        id = id,
        surnameIN = input.split(" ").getOrNull(0),
        git = input.split(" ").getOrNull(1),
        contact = input.split(" ").getOrNull(2)
    )

    constructor(student: Student) : this(
        id = student.id,
        surnameIN = student.getSHName(),
        git = student.getSHGIT(),
        contact = student.getContact()
    )

    override fun toString(): String {

        var field = "id $id, " + "F.I.O. $surnameIn,"
        if(!git.isNullOrEmpty()) field += " $git,"
        if(!contact.isNullOrEmpty()) field += " Contact $contact,"

        return field
    }
}