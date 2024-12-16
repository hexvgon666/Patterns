class Data_table(private val data: List<List<Any>>) {
    fun GetNumCol(): Int {
        return data[0].size
    }

    fun GetNumRow(): Int {
        return data.size
    }

    fun GetElem(rowindex: Int, colindex: Int): Any? {
        return data.getOrNull(rowindex)?.getOrNull(colindex)
    }

    override fun toString(): String {
        val str = StringBuilder()
        for (row in data) {
            str.append(row.joinToString(", ") { it.toString() }) // Ïðåîáðàçóåò êàæäóþ ñòðîêó â ñòðîêó
            str.append("\n")
        }
        return str.toString()
    }
}
