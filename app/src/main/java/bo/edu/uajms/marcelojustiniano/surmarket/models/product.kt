package bo.edu.uajms.marcelojustiniano.surmarket.models

data class product(
    val id: Int,
    var name: String,
    var categoryval :String,
    var price: Double,
    var imageUrlval : String,
    var description: String,
    var available: Boolean,
    var stock:Int
) {

}