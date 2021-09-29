fun main() {
    val cardType = "Vk Pay";
    commission(cardType);
}

fun commission(cardType: String) {
    val transferAmount = 15000000;
    val amountOfPreviousTransfers = 0;
    val cardSelection = when (cardType) {
        "Vk Pay" -> vk_pay(transferAmount, amountOfPreviousTransfers)
        "Mastercard", "Maestro" -> mastercard_maestro(transferAmount, amountOfPreviousTransfers)
        "Visa", "Мир" -> visa_mir(transferAmount, amountOfPreviousTransfers)
        else -> println("Данный вид пластиковых карт не поддерживается!")
    }
}

fun vk_pay(transferAmount: Int, amountOfPreviousTransfers: Int) {
    if (transferAmount / 100 <= 15000 && amountOfPreviousTransfers / 100 <= 40000) {
        println("Комиссия за перевод 0 копеек");
    } else {
        println("Превышен лимит!")
    }
}

fun mastercard_maestro(transferAmount: Int, amountOfPreviousTransfers: Int) {
    val commission = 0.6;
    val commissionForTranslation = transferAmount * commission + 2000;
    val cardTransferCommission = when (transferAmount) {
        in 300..75000 -> println("Комиссия не взимается!")
        else -> println(commissionForTranslation)
    }
}

fun visa_mir(transferAmount: Int, amountOfPreviousTransfers: Int) {
    val commission = 0.75;
    val minimumCommission = 3500;
    val commissionForTranslation = transferAmount * commission;
    var cardTransferCommission = 0;
    if (commissionForTranslation < minimumCommission) {
        cardTransferCommission = minimumCommission;
    } else {
        cardTransferCommission = commissionForTranslation.toInt();
    }
    println("Комиссия за перевод: $cardTransferCommission копеек!");
}