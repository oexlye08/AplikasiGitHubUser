package id.my.okisulton.aplikasigithubuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

	val users: List<UsersItem>,
) : Parcelable {
    @Parcelize
    data class UsersItem(

		val follower: Int? = null,

		val following: Int? = null,

		val name: String? = null,

		val company: String? = null,

		val location: String? = null,

		val avatar: String? = null,

		val repository: Int? = null,

		val username: String? = null,
	) : Parcelable
}
