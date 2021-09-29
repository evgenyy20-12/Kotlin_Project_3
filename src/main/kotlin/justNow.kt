fun main() {
    agoToText(7200);
}

fun agoToText(numberOfSeconds: Int) {
    val presence = when (numberOfSeconds) {
        in 0..60 -> "был(а) в сети только что"
        in 61..3599 -> selectMinutes(numberOfSeconds)
        in 3600..86399 -> selectHour(numberOfSeconds)
        in 86400..172799 -> println("был(а) в сети сегодня")
        in 172800..259199 -> println("был(а) в сети вчера")
        else -> "был(а) в сети давно"
    }
    println(presence);
}

fun selectMinutes(seconds: Int) {
    val minutes = seconds / 60;
    when (minutes) {
        21, 31, 41, 51 -> println("был(а) в сети $minutes минуту назад")
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> println("был(а) в сети $minutes минуты назад")
        in 5..20, in 25..30, in 35..40, in 45..50, in 55..59 -> println("был(а) в сети $minutes минут назад")
    }
}

fun selectHour(seconds: Int) {
    val hour = seconds / 3600;
    when (hour) {
        1, 21 -> println("был(а) в сети $hour час назад")
        2, 3, 4, 22, 23-> println("был(а) в сети $hour часа назад")
        in 5..20 -> println("был(а) в сети $hour часов назад")
    }
}

