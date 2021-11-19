package id.my.okisulton.aplikasigithubuser.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.my.okisulton.aplikasigithubuser.databinding.ActivityDetailUserBinding
import id.my.okisulton.aplikasigithubuser.model.User

class DetailUserActivity : AppCompatActivity() {
    private val TAG: String = "DetailUserActivity"
    private var _binding: ActivityDetailUserBinding? = null
    private val binding get() = _binding
    var username: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()
        setupListener()
        getData()
    }

    private fun setupListener() {
        binding?.apply {
            backButton.setOnClickListener { finish() }
            btnShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "https://github.com/$username")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }

            fabOpenGithub.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/$username"))
                startActivity(browserIntent)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getData() {
        val data = intent.getParcelableExtra<User.UsersItem>(DETAIL_USER) as User.UsersItem
        val uri = data.avatar
        val imageResources: Int =
            applicationContext.resources.getIdentifier(uri, null, applicationContext.packageName)
        val res: Drawable = applicationContext.resources.getDrawable(imageResources)

        username = data.username.toString()


        binding?.apply {
            tvNameDetail.text = data.name
            tvCompanyDetail.text = data.company
            tvRepositoryDetail.text = data.repository.toString()
            tvFollowerDetail.text = data.follower.toString()
            tvFollowingDetail.text = data.following.toString()
            tvUsernameDetail.text = data.username
            tvLocationDetail.text = data.location

            Glide.with(applicationContext)
                .load(res)
                .circleCrop()
                .into(imgAvatar)
        }
    }


    companion object {
        const val DETAIL_USER = "detail_user"
    }

}