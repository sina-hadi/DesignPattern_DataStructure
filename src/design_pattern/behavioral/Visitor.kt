package design_pattern.behavioral

fun main() {
    val projectAlpha = FixedPriceContract(costPerYear = 10000)
    val projectGamma = TimeAndMaterialsContract(hours = 150, costPerHour = 10)
    val projectBeta = SupportContract(costPerMonth = 500)
    val projectKappa = TimeAndMaterialsContract(hours = 50, costPerHour = 50)

    val projects = arrayOf(projectAlpha, projectBeta, projectGamma, projectKappa)

    val monthlyCostReportVisitor = MonthlyCostReportVisitor()

    val monthlyCost = projects.sumOf { it.accept(monthlyCostReportVisitor) }
    println("Monthly cost: $monthlyCost")

    val yearlyReportVisitor = YearlyReportVisitor()
    val yearlyCost = projects.sumOf { it.accept(yearlyReportVisitor) }
    println("Yearly cost: $yearlyCost")
}

interface ReportVisitable {
    fun <R> accept(visitor: ReportVisitor<R>): R
}

class FixedPriceContract(val costPerYear: Long) : ReportVisitable {
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

class TimeAndMaterialsContract(val costPerHour: Long, val hours: Long) : ReportVisitable {
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

class SupportContract(val costPerMonth: Long) : ReportVisitable {
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

interface ReportVisitor<out R> {

    fun visit(contract: FixedPriceContract): R
    fun visit(contract: TimeAndMaterialsContract): R
    fun visit(contract: SupportContract): R
}

class MonthlyCostReportVisitor : ReportVisitor<Long> {

    override fun visit(contract: FixedPriceContract): Long = contract.costPerYear / 12

    override fun visit(contract: TimeAndMaterialsContract): Long = contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long = contract.costPerMonth
}

class YearlyReportVisitor : ReportVisitor<Long> {

    override fun visit(contract: FixedPriceContract): Long = contract.costPerYear

    override fun visit(contract: TimeAndMaterialsContract): Long = contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long = contract.costPerMonth * 12
}

/**
 * Separate different functions
 * with Override and Overload
 * with data that they hold
 */