package iph.interactivelist.application.Model

data class Post(
    val userName: String,
    val groupName: String,
    val postText: String,
    var postDate:String,
    val postPic: String)