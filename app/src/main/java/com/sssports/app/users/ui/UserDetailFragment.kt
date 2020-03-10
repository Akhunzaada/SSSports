package com.sssports.app.users.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sssports.app.R
import com.sssports.app.databinding.FragmentUserDetailBinding
import com.sssports.app.di.Injectable

/**
 * A fragment representing a single LegoSet detail screen.
 */
class UserDetailFragment : Fragment(), Injectable {

    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentUserDetailBinding>(
                inflater, R.layout.fragment_user_detail, container, false)

        binding.user = args.user

        return binding.root
    }
}
