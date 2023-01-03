package design_pattern.structural

typealias PointsOfDamage = Long
typealias Meters = Int

const val GRENADE_DAMAGE: PointsOfDamage = 5L
const val RIFLE_DAMAGE = 3L
const val REGULAR_SPEED: Meters = 1

fun main() {
    val rifleman = Soldier(Rifle(), RegularLegs())
    val grenadier = Soldier(Grenade(), RegularLegs())
    val upgradedGrenadier = Soldier(GrenadePack(), RegularLegs())
    val upgradedRifleman = Soldier(MachineGun(), RegularLegs())
    val lightRifleman = Soldier(Rifle(), AthleticLegs())
    val lightGrenadier = Soldier(Grenade(), AthleticLegs())
}

interface Infantry {
    fun move(x: Long, y: Long)
    fun attack(x: Long, y: Long)
}

interface Weapon {
    fun causeDamage(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

// Infantry
class Soldier(
    private val weapon: Weapon,
    private val legs: Legs
) : Infantry {
    override fun attack(x: Long, y: Long) {
        // Find target
        // Shoot
        weapon.causeDamage()
    }

    override fun move(x: Long, y: Long) {
        // Compute direction
        // Move at its own pace
        legs.move()
    }
}

// Weapon
class Grenade : Weapon {
    override fun causeDamage() = GRENADE_DAMAGE
}

class GrenadePack : Weapon {
    override fun causeDamage() = GRENADE_DAMAGE * 3
}

class Rifle : Weapon {
    override fun causeDamage() = RIFLE_DAMAGE
}

class MachineGun : Weapon {
    override fun causeDamage() = RIFLE_DAMAGE * 2
}

// Legs
class RegularLegs : Legs {
    override fun move() = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move() = REGULAR_SPEED * 2
}

/**
 * Infantry --> Soldier

 * Weapon --> Rifle
--> MachineGun
--> Grenade
--> GrenadePack

 * Legs --> RegularLegs
--> AthleticLegs
 */