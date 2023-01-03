package design_pattern.creational

fun main() {

    val pcFromWarehouse = PC()
    val powerfulPC = pcFromWarehouse.copy(
        graphicCard = "NKF 8999TXX",
        ram = "16GB BBR6"
    )
    println(powerfulPC)
}

data class PC(
    val motherboard: String = "Terasus XZ27",
    val cpu: String = "Until Atom K500",
    val ram: String = "8GB Microcend BBR5",
    var graphicCard: String = "nKCF 8100TZ"
)