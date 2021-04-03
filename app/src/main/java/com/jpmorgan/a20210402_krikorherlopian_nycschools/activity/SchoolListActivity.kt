package com.jpmorgan.a20210402_krikorherlopian_nycschools.activity

import androidx.fragment.app.Fragment
import com.jpmorgan.a20210402_krikorherlopian_nycschools.R
import com.jpmorgan.a20210402_krikorherlopian_nycschools.fragment.SchoolListFragment
import kotlinx.android.synthetic.main.activity_fragment.*

// I used kotlin extensions in this class, to access toolbar Rather then using findviewbyid.
// Class extends SingleFragmentActivity, any activity that contains one single fragment can utilize it instead of writing more code.
class SchoolListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        toolbar?.title = resources.getString(R.string.list_ny_schools)
        return SchoolListFragment();
    }
}