package iph.interactivelist.application.UI

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import iph.interactivelist.application.Model.Post
import iph.interactivelist.application.Model.PostAdapter
import iph.interactivelist.application.R
import iph.interactivelist.application.UtilsMethod.UtilsMethod
import iph.interactivelist.application.databinding.ActivityMainBinding
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {

    //Initialization
    private var backPressed: Long = 0
    private  var isRefresh:Boolean=false
    private lateinit var binding: ActivityMainBinding
    private val postAdapter = PostAdapter()
    private lateinit var  jsonString:String

    //Override function onCreate to set content view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting the json from assets folder
        jsonString=UtilsMethod.INSTANCE.getJsonFromAssets(this,"Post.json")

        bindings()
        getPostList();
        refresh()
    }

    //Function for activity view binding
    private fun bindings() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //Function to load the list data
    private fun getPostList() {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Post?>?>() {}.type
        val jsonData: List<Post> = gson.fromJson(jsonString, type)

        binding.recyclerview.adapter = postAdapter
        postAdapter.setPostList(this,jsonData.subList(0,4))
    }

    //Function that refresh the list when SwipeRefreshLayout scrolled
    private fun refresh() {
        binding.swipeToRefresh.setColorSchemeColors(Color.RED, Color.MAGENTA, Color.GREEN)
        binding.swipeToRefresh.setOnRefreshListener {
            binding.swipeToRefresh.isRefreshing = true
            Handler().postDelayed(Runnable {
                if (isRefresh){
                    Toast.makeText(this,"No more data to load", Toast.LENGTH_LONG).show()
                }
                else{
                    getNewPostList();
                }
                binding.swipeToRefresh.isRefreshing = false
            }, 3000)
        }
    }

    // Function to re-load the list data
    private fun getNewPostList() {
        isRefresh=true
        val gson = Gson()
        val type: Type = object : TypeToken<List<Post?>?>() {}.type
        val jsonData: List<Post> = gson.fromJson(jsonString, type)
        binding.recyclerview.adapter = postAdapter
        postAdapter.setPostList(this,jsonData.reversed())

    }

    //Override function onBackPress to close the app
    override fun onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        } else {
            Toast.makeText(this, "Hit back again to close app", Toast.LENGTH_SHORT).show()
            backPressed = System.currentTimeMillis()
        }
    }


}