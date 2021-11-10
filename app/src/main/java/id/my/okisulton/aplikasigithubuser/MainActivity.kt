package id.my.okisulton.aplikasigithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import id.my.okisulton.aplikasigithubuser.adapter.UserAdapter
import id.my.okisulton.aplikasigithubuser.databinding.ActivityMainBinding
import id.my.okisulton.aplikasigithubuser.model.User
import android.R




class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setupRv()
        getDataUser()
    }

    private fun getDataUser() {

    }

    private fun setupRv() {
        userAdapter = UserAdapter(arrayListOf(),
        object : UserAdapter.OnAdapterListener {
            override fun onClick(result: User.UsersItem) {
                Log.d(TAG, "onClick: Name = ${result.name}")
            }
        })

        binding.rvListUser.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }
}