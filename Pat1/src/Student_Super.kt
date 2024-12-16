open class Student_Super(
    id: Int,
    git: String? = null,
)
{
    var id: Int = id
        get() {
            return field
        }
        set(value) {
            require(value > 0)
            {
                "ID должно быть больше 0"
            }
            field = value
        }

    var git: String? = git
        get() {
            return field
        }
        set(value) {
            field = value
        }
}