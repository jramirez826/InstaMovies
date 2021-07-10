package com.jramirez.instamovies.domain.model

enum class SeriesGenre(private val title: String, private val id: Int) : BaseGenre {
    SCI_FI(title = "Science Fiction", id = 10765),
    SOAP(title = "Action & Adventure", id = 10759),
    TALK(title = "Talk", id = 10767);

    override fun id(): Int = this.id

    override fun title(): String = this.title
}