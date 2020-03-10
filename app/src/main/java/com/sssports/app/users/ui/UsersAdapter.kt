package com.sssports.app.users.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sssports.app.databinding.ListItemUserBinding
import com.sssports.app.users.data.User

/**
 * Adapter for the [RecyclerView] in [UsersFragment].
 */
class UsersAdapter : PagedListAdapter<User, UsersAdapter.ViewHolder>(UsersDiffCallback()) {

    private lateinit var recyclerView: RecyclerView

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        user?.let {
            holder.apply {
                bind(createOnClickListener(user), user)
                itemView.tag = user
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    private fun createOnClickListener(user: User): View.OnClickListener {
        return View.OnClickListener {
            val direction = UsersFragmentDirections.actionToUserDetailFragment(user)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val binding: ListItemUserBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: User) {
            binding.apply {
                clickListener = listener
                user = item
                executePendingBindings()
            }
        }
    }
}

private class UsersDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id.value == newItem.id.value
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}