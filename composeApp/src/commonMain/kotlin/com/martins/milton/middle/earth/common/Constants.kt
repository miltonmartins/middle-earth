package com.martins.milton.middle.earth.common

object Constants {
    object Api {
        object Path {
            const val MOVIES = "movie"
            const val CHARACTERS = "character"
        }

        object Param {
            const val PAGE = "page"
            const val SORT = "sort"
            const val SORT_BY_NAME_ASC = "name:asc"
            const val LIMIT = "limit"
        }

        object Filter {
            const val NAME = "name"
        }

        const val MIN_LIMIT = 10
        const val MAX_LIMIT = 50
    }
}