package id.my.okisulton.aplikasigithubuser.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import id.my.okisulton.aplikasigithubuser.adapter.UserAdapter
import id.my.okisulton.aplikasigithubuser.databinding.ActivityMainBinding
import id.my.okisulton.aplikasigithubuser.model.User
import id.my.okisulton.aplikasigithubuser.utils.getDataFromAsset


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
        val jsonFileString = getDataFromAsset(applicationContext, "githubuser.json")
        Log.d(TAG, "onCreate: $jsonFileString")
        val user = Gson().fromJson(jsonFileString, User::class.java)
        showResult(data = user)

    }

    private fun showResult(data: User) {
        val listUser = data.users
        userAdapter.setData(listUser)
    }

    private fun setupRv() {
        userAdapter = UserAdapter(arrayListOf(),
            object : UserAdapter.OnAdapterListener {
                override fun onClick(result: User.UsersItem) {
                    Log.d(TAG, "onClick: Name = ${result.name}")
                    val moveData = Intent(this@MainActivity, DetailUserActivity::class.java)
                    moveData.putExtra(DetailUserActivity.DETAIL_USER, result)
                    startActivity(moveData)
                }
            })

        binding.rvListUser.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }
}