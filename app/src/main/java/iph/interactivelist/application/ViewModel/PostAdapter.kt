package iph.interactivelist.application.Model

import android.R.attr.data
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import iph.interactivelist.application.R
import iph.interactivelist.application.databinding.AdapterFeedBinding


class PostAdapter: RecyclerView.Adapter<MainViewHolder>() {

    //Initialization
    var posts = mutableListOf<Post>()
    lateinit var  context: Context

    //Define the constructor
    fun setPostList(context: Context,posts: List<Post>) {
        this.context=context
        this.posts = posts.toMutableList()
        notifyDataSetChanged()
    }

    //Create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterFeedBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    //Binds the list items to a view
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val post = posts[position]

        //get json and binding to view
        holder.binding.tvUserName.text = post.userName
        holder.binding.tvGroupName.text = post.groupName
        holder.binding.tvPostDate.text = post.postDate
        holder.binding.tvPostText.text = post.postText

        // get post image name from JSON
        val imageName: String = post.postPic

        // get resource id by image name
        val resourceId: Int = context.resources.getIdentifier(imageName, "drawable", context.packageName)

        // get drawable by resource id
        val drawable: Drawable = context.resources.getDrawable(resourceId)


        //load user pic and post image using Glide library
        Glide.with(holder.itemView.context).load(drawable).into(holder.binding.ivUserPic)
        Glide.with(holder.itemView.context).load(drawable).into(holder.binding.ivPostImage)


        // toast message will display when user click on three dot
        holder.binding.ivThreeDot.setOnClickListener(){
           Toast.makeText(context,post.groupName,Toast.LENGTH_LONG).show()
        }
    }

    //Return the number of the items in the list
    override fun getItemCount(): Int {
        return posts.size
    }
}


class MainViewHolder(val binding: AdapterFeedBinding) : RecyclerView.ViewHolder(binding.root) {}
