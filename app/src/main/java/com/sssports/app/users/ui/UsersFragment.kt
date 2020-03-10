package com.sssports.app.users.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sssports.app.R
import com.sssports.app.databinding.FragmentUsersBinding
import com.sssports.app.databinding.FragmentUsersBindingImpl
import com.sssports.app.di.Injectable
import com.sssports.app.di.injectViewModel
import com.sssports.app.ui.VerticalItemDecoration
import com.sssports.app.ui.hide
import javax.inject.Inject

class UsersFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: UsersViewModel

    private lateinit var binding: FragmentUsersBinding
    private val adapter: UsersAdapter by lazy { UsersAdapter() }
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val linearDecoration: RecyclerView.ItemDecoration by lazy {
        VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        binding = FragmentUsersBinding.inflate(inflater, container, false)
        context ?: return binding.root

        linearLayoutManager = LinearLayoutManager(activity)
        setLayoutManager()
        binding.recyclerView.adapter = adapter

        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: UsersAdapter) {
        viewModel.legoSets.observe(viewLifecycleOwner) {
            binding.progressBar.hide()
            adapter.submitList(it)
        }
    }

    private fun setLayoutManager() {
        val recyclerView = binding.recyclerView
        var scrollPosition = 0
        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager)
                    .findFirstCompletelyVisibleItemPosition()
        }

        recyclerView.addItemDecoration(linearDecoration)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.scrollToPosition(scrollPosition)
    }
}
