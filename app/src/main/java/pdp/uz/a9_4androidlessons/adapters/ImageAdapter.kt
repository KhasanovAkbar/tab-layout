package pdp.uz.a9_4androidlessons.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pdp.uz.a9_4androidlessons.ImageFragment
import pdp.uz.a9_4androidlessons.models.Data

class ImageAdapter(var list: ArrayList<Data>, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ImageFragment.newInstance(list[position])
    }
}