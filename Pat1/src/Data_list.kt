open class Data_list<T>(val data: Array<T>)
{
    private val select = mutableListOf<Int>()

    fun select(num:Int)
    {
        if(num < data.size)
        {
            select.add(num)
        }
    }

    fun get_selected() : MutableList<Int>
    {
        return select
    }

    open fun get_names(id:Int): Data_table
    {
        throw NotImplementedError(" ")
    }

    open fun get_data(): Data_table
    {

        throw NotImplementedError(" ")
    }

}