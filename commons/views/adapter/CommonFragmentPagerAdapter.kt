package skycap.com.driver.go4er.views.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CommonFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = mutableListOf<Fragment>()
    private val titles = mutableListOf<String>()


    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }

    fun addTab(title: String, fragment: Fragment): CommonFragmentPagerAdapter {
        fragments.add(fragment)
        titles.add(title)

        return this
    }
}
