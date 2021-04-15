package am.example.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameTxt = findViewById<TextView>(R.id.textView)
        val descriptionTxt = findViewById<TextView>(R.id.textView2)
        val idTxt = findViewById<TextView>(R.id.textView3)
        val priceTxt = findViewById<TextView>(R.id.textView4)
        val discount_amountTxt = findViewById<TextView>(R.id.textView5)

        GlobalScope.launch(Dispatchers.IO ){
            val call = UserRetrofitService.retrofit.create(UserAPI::class.java).getSingleUser()
            val data =  call.execute().body()?.data

            withContext(Dispatchers.Main){
                nameTxt.setText(data?.name)
                descriptionTxt.setText(data?.description)
                idTxt.setText(data?.id.toString())
                priceTxt.setText(data?.price)
                discount_amountTxt.setText(data?.discount_amount)
            }
        }



    }
}