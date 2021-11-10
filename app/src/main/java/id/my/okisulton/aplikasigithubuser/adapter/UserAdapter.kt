package id.my.okisulton.aplikasigithubuser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.my.okisulton.aplikasigithubuser.databinding.ListUserBinding
import id.my.okisulton.aplikasigithubuser.model.User

/**
 * Created by Oki Sulton on 05/11/2021.
 */
class UserAdapter(
    val listUser: ArrayList<User.UsersItem>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface OnAdapterListener {
        fun onClick(result: User.UsersItem)
    }

    class ViewHolder (val binding: ListUserBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        ListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listUser[position]
        holder.binding.tvName.text = data.name
        holder.binding.tvUsername.text = data.username
        Glide.with(holder.binding.root)
            .load(data.avatar)
            .circleCrop()
            .into(holder.binding.imageView)

        holder.binding.root.setOnClickListener { listener.onClick(data) }
    }

    override fun getItemCount(): Int = listUser.size

    fun setData(data: List<User.UsersItem>) {
        listUser.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        listUser.clear()
        notifyDataSetChanged()
    }
}