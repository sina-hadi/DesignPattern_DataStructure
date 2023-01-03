package train

interface CatPictureSaver {
    fun save(picture: train.Picture)
    fun load(picturePath: String): train.Picture
}

class CatPictureFileSaver : CatPictureSaver {
    override fun save(picture: train.Picture) {
        println("${picture.name} -> ${picture.url}")
    }

    override fun load(picturePath: String): train.Picture {
        println("picturePath")
        return train.Picture("Hello", "There")
    }
}

class CatFilter(
    private val picture: train.Picture, private val pictureSaver: CatPictureSaver
) {
    fun filterPixels() {
        val filteredPicture = train.Picture("sina", "/sina-hadi")
        pictureSaver.save(filteredPicture)
    }
}

interface Shape {
    fun getArea(): Double
}

class Square(private val side: Double) : Shape {
    override fun getArea(): Double {
        return side * side
    }
}

class Triangle(private val base: Double, private val height: Double) : Shape {
    override fun getArea(): Double {
        return base * height / 2
    }
}

class AreaCalculate {
    fun getShapeArea(shape: Shape): Double {
        return shape.getArea()
    }
}


fun main() {
//    CatFilter(past.Picture("1","2"), CatPictureFileSaver()).filterPixels()

//    println(AreaCalculate().getShapeArea(Triangle(5.0,3.0)))

    class Printer(private val stringFormatterStrategy: (String) -> String) {

        fun printString(string: String) {
            println(stringFormatterStrategy(string))
        }
    }

    val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }
    val upperCaseFormatter = { it: String -> it.toUpperCase() }


}