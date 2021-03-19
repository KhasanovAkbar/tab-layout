package pdp.uz.a9_4androidlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.gson.Gson
import pdp.uz.a9_4androidlessons.models.Data
import pdp.uz.a9_4androidlessons.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    private var gson = Gson()
    lateinit var list: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MySharedPreference.init(this)
        loadData()

    }

    private fun loadData() {
        list = ArrayList()

        list.add(
            Data(
                R.drawable.geoaxborot,
                "Geoaxborot",
                "Geoaxborot moduli orqali siz o'zingizga yaqin bo'lgan migrantlar va boshqa muassasalar haqida ma'lumot olishingiz mumkin"
            )
        )

        list.add(
            Data(
                R.drawable.question,
                "Huquqiy axborot",
                "Huquqiy axborot moduli orqali siz migratsiya sohasiga oid yangiliklardan, qonunlardan xabardor bo'lishingiz va online konsultatsiya olishingiz mumkin"
            )
        )

        list.add(
            Data(
                R.drawable.tolovlar,
                "To'lovlar xizmati",
                "To'lovlar moduli orqali siz masofadan turib turli xil xizmatlarga to'lovlar haqida ma'lumot olishingiz va to'lovlarni amalga oshirishingiz mumkin"
            )
        )

        list.add(
            Data(
                R.drawable.qoshimcha,
                "Qo'shimcha imkoniyat",
                "Qo'shimcha imkoniyatlar moduli orqali siz interaktiv so'zlashgichlar va lug'atlar yordamida til bilish savodxonligingizni oshirishingiz mumkin"
            )
        )

        val toJson = gson.toJson(list)
        MySharedPreference.info = toJson
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }
}