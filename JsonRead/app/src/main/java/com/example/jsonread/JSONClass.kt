

package com.example.jsonread

data class kpop(
    val singers: List<Singers>
)

data class Singers(
    val agency: String,
    val name: String,
    val year_of_debut: Int
)