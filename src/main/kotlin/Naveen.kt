fun main(args: Array<String>) {
    checkNaN()
}

fun checkNaN() {
    val licensedAssetsCount = 10
    val licensedAssetsLimit = 0


    val temp = (licensedAssetsCount.toDouble().times(100)).div(licensedAssetsLimit.toDouble())
    val licenseUtilization =
        if (!((String.format("%.2f", (licensedAssetsCount.toDouble().times(100)).div(licensedAssetsLimit.toDouble()))
                .toDouble()).isNaN())
        ) {
            "Valid NUumber"
        } else "Is not valid number"

    println("------- $licenseUtilization -----")
}
