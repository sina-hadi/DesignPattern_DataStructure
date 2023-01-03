package design_pattern.creational

fun main() {
    val hq = HQ()
    val barracks1 = hq.buildBarracks()
    val barracks2 = hq.buildBarracks()
    val vehicleFactory1 = hq.buildVehicleFactory()

    val units = listOf(
        barracks1.build(InfantryUnits.RIFLEMEN),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        vehicleFactory1.build(VehicleUnits.TANK),
        vehicleFactory1.build(VehicleUnits.APC),
        vehicleFactory1.build(VehicleUnits.APC)
    )
}

interface Building<in T, out P>
        where T : Enum<*>, P : Unit {
    fun build(type: T) : P
}

interface Unit
interface Vehicle : Unit
interface Infantry : Unit

class HQ {
    private val buildings = mutableListOf<Building<*, Unit>>()

    fun buildBarracks(): Barracks {
        val b = Barracks()
        buildings.add(b)
        return b
    }
    fun buildVehicleFactory(): VehicleFactory {
        val vf = VehicleFactory()
        buildings.add(vf)
        return vf
    }
}

class Rifleman : Infantry
class RocketSoldier : Infantry
enum class InfantryUnits {
    RIFLEMEN,
    ROCKET_SOLDIER
}

class APC : Vehicle
class Tank : Vehicle
enum class VehicleUnits {
    APC,
    TANK
}

class Barracks : Building<InfantryUnits, Infantry> {
    override fun build(type: InfantryUnits): Infantry {
        return when (type) {
            InfantryUnits.RIFLEMEN -> Rifleman()
            InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
        }
    }
}

class VehicleFactory : Building<VehicleUnits, Vehicle> {
    override fun build(type: VehicleUnits) = when (type) {
        VehicleUnits.APC -> APC()
        VehicleUnits.TANK -> Tank()
    }
}