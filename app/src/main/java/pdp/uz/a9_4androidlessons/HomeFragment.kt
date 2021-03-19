package pdp.uz.a9_4androidlessons

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import pdp.uz.a9_4androidlessons.adapters.ImageAdapter
import pdp.uz.a9_4androidlessons.models.Data
import pdp.uz.a9_4androidlessons.utils.MySharedPreference
import java.lang.reflect.Type


class HomeFragment : Fragment() {
    lateinit var root: View
    private var gson = Gson()
    lateinit var data: ArrayList<Data>
    lateinit var handler: Handler
    lateinit var imageAdapter: ImageAdapter

    //    lateinit var pageIndicator: PageIndicatorView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        MySharedPreference.init(container!!.context)
//        pageIndicator = root.findViewById(R.id.page_indicator_view)
        val info = MySharedPreference.info
        val type: Type = object : TypeToken<ArrayList<Data>>() {}.type
        data = gson.fromJson(info, type)


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingStatusBarTransparent()
        imageAdapter = ImageAdapter(data, childFragmentManager)
        view_pager.adapter = imageAdapter
        tab_indicator.setViewPager(view_pager)
        tab_indicator.jumpDrawablesToCurrentState()
        handler = Handler()

        root.registration_btn.setOnClickListener {
            if (view_pager.currentItem == 3) {
                root.findNavController().navigate(R.id.firstFragment)
            }
        }
        root.next_btn.setOnClickListener {
            handler.postDelayed(runnable, 2000)

        }
    }

    private var runnable = object : Runnable {
        override fun run() {
            view_pager.currentItem = 3


        }

    }

    private fun settingStatusBarTransparent() {
        val w: Window = requireActivity().window // in Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            w.navigationBarColor = Color.BLACK
            w.setFlags(
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
            )
            w.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            w.statusBarColor = Color.TRANSPARENT
        }
    }

}