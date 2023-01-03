package design_pattern.creational

fun main() {
    // Without Type
    println(AnimalFactory.pickAnimal(DogOrCat.DOG).name)
    println(AnimalFactory.pickAnimal(DogOrCat.CAT).name)

    // With Type
    println(
        AnimalFactory.pickAnimal
            (DogOrCat.DOG, dBreed = DogBreed.BEAGLE).name
    )
    println(
        AnimalFactory.pickAnimal
            (DogOrCat.CAT, cBreed = CatBreed.RUSSIAN_BLUE).name
    )

}

interface Animal {
    val name: String
}

class Dog : Animal {
    override val name: String
        get() = "DOG"
}

class Cat : Animal {
    override val name: String
        get() = "CAT"
}

// Destructuring declaration
object DogFactory {
    fun createDog(breed: DogBreed?): Animal =
        when (breed) {
            DogBreed.BULLDOG -> Dog() // Bulldog
            DogBreed.BEAGLE -> Dog() // Beagle
            DogBreed.POODLE -> Dog() // Poodle
            null -> Dog()
        }
}

object CatFactory {
    fun createCat(breed: CatBreed?): Animal =
        when (breed) {
            CatBreed.PERSIAN -> Cat() // Persian
            CatBreed.RUSSIAN_BLUE -> Cat() // Russian blue
            CatBreed.SIAMESE -> Cat() // Siamese
            null -> Cat()
        }
}

object AnimalFactory {
    fun pickAnimal(
        dogOrCat: DogOrCat,
        dBreed: DogBreed? = null,
        cBreed: CatBreed? = null
    ): Animal {
        return when (dogOrCat) {
            DogOrCat.DOG -> DogFactory.createDog(dBreed)
            DogOrCat.CAT -> CatFactory.createCat(cBreed)
        }
    }
}

enum class DogOrCat {
    DOG,
    CAT
}

enum class DogBreed {
    BULLDOG,
    BEAGLE,
    POODLE
}

enum class CatBreed {
    PERSIAN,
    RUSSIAN_BLUE,
    SIAMESE
}

/**
 * That's what Factory Method is all about:
 * Get some value.
 * Return one of the objects that implement the common interface.
 */