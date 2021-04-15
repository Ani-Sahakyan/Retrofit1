package am.example.retrofit1

import android.service.autofill.UserData

class UserModel{

    var code : Int? = null
    var meta = null
    var data : Data? = null

    data class Data(
        var id:Int,
        var name: String,
        var description: String,
        var image : String,
        var price: String,
        var discount_amount: String,
        var status : Boolean,
        var categories : List<Categories>?
    )

    data class Categories(
        var id : Int,
        var name : String
    )
}