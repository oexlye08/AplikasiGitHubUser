package id.my.okisulton.aplikasigithubuser.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
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
    private val listUser: ArrayList<User.UsersItem>,
    private val listener: OnAdapterListener,
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface OnAdapterListener {
        fun onClick(result: User.UsersItem)
    }

    class ViewHolder(val binding: ListUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listUser[position]
        val uri = data.avatar
        val itemView = holder.binding.root

        holder.binding.tvName.text = data.name
        holder.binding.tvUsername.text = data.username

        val imageResorce: Int =
            itemView.context.resources.getIdentifier(uri, null, itemView.context.packageName)
        val res: Drawable = itemView.context.resources.getDrawable(imageResorce)

        Glide.with(holder.binding.root)
            .load(res)
            .circleCrop()
            .into(holder.binding.imageView)

        itemView.setOnClickListener { listener.onClick(data) }


    }

    override fun getItemCount(): Int = listUser.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<User.UsersItem>) {
        listUser.addAll(data)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        listUser.clear()
        notifyDataSetChanged()
    }
}