package com.jramirez.instamovies.domain.model

enum class MovieGenre(private val title: String, private val id: Int) : BaseGenre {
    SCI_FI(title = "Science Fiction", id = 878),
    COMEDY(title = "Comedy", id = 35);

    override fun id(): Int = this.id

    override fun title(): String = this.title
}