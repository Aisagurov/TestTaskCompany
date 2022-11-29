package suvorov.testtaskcompany.util

fun String?.emptyStringIfNull(): String {
    return this ?: ""
}

fun Double?.emptyDoubleIfNull(): Double {
    return this ?: 0.0
}
