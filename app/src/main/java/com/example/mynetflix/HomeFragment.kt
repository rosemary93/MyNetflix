package com.example.mynetflix

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val favoriteButtonList = ArrayList<Button>()
    val imageViewList=ArrayList<ImageView>()
    val textViewList=ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        NetflixEnvironment.testData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //createViewsArrays()
        //initLastViews()
        var adapter=ListAdapter(NetflixEnvironment.filmList)
        binding.rvFilmList.adapter=adapter

        adapter.setOnButtonClickListener(object :ListAdapter.onButtonClickListener{
            override fun onButtonClick(position: Int) {
                adapter.dataset[position].isFavorite=(!adapter.dataset[position].isFavorite)
            }
        })





/*

        for (i in 0 until favoriteButtonList.size)
        {
            favoriteButtonList[i].setOnClickListener {
                NetflixEnvironment.filmList[i].isFavorite = (!(NetflixEnvironment.filmList[i].isFavorite))
                if (NetflixEnvironment.filmList[i].isFavorite)
                {
                    favoriteButtonList[i].setBackgroundColor(Color.RED)
                }else{
                    favoriteButtonList[i].setBackgroundColor(resources.getColor(R.color.purple_500))
                }
            }
        }
*/



    }

   /* fun initLastViews(){
        for (i in 0..11)
        {
            textViewList[i].text=NetflixEnvironment.filmList[i].title
            if (NetflixEnvironment.filmList[i].isFavorite)
                favoriteButtonList[i].setBackgroundColor(Color.RED)
        }
    }*/

    //for adding menu and set items listeners
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                findNavController().navigate(R.id.action_homeFragment_to_profileRegistrationFragment)
                return true
            }
            R.id.favorite -> {
                findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                return true
            }
            R.id.coming_soon -> {
                findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    /*fun createViewsArrays()
    {
        createButtonArray()
        createImageViewArray()
        createTextViewArray()
    }

    fun createButtonArray() {

        favoriteButtonList.add(binding.buttonFavorite0)
        favoriteButtonList.add(binding.buttonFavorite1)
        favoriteButtonList.add(binding.buttonFavorite2)
        favoriteButtonList.add(binding.buttonFavorite3)
        favoriteButtonList.add(binding.buttonFavorite4)
        favoriteButtonList.add(binding.buttonFavorite5)
        favoriteButtonList.add(binding.buttonFavorite6)
        favoriteButtonList.add(binding.buttonFavorite7)
        favoriteButtonList.add(binding.buttonFavorite8)
        favoriteButtonList.add(binding.buttonFavorite9)
        favoriteButtonList.add(binding.buttonFavorite10)
        favoriteButtonList.add(binding.buttonFavorite11)
    }
    fun createImageViewArray(){
        imageViewList.add(binding.imageView0)
        imageViewList.add(binding.imageView1)
        imageViewList.add(binding.imageView2)
        imageViewList.add(binding.imageView3)
        imageViewList.add(binding.imageView4)
        imageViewList.add(binding.imageView5)
        imageViewList.add(binding.imageView6)
        imageViewList.add(binding.imageView7)
        imageViewList.add(binding.imageView8)
        imageViewList.add(binding.imageView9)
        imageViewList.add(binding.imageView10)
        imageViewList.add(binding.imageView11)
    }
    fun createTextViewArray()
    {
        textViewList.add(binding.textViewFilmTitle0)
        textViewList.add(binding.textViewFilmTitle1)
        textViewList.add(binding.textViewFilmTitle2)
        textViewList.add(binding.textViewFilmTitle3)
        textViewList.add(binding.textViewFilmTitle4)
        textViewList.add(binding.textViewFilmTitle5)
        textViewList.add(binding.textViewFilmTitle6)
        textViewList.add(binding.textViewFilmTitle7)
        textViewList.add(binding.textViewFilmTitle8)
        textViewList.add(binding.textViewFilmTitle9)
        textViewList.add(binding.textViewFilmTitle10)
        textViewList.add(binding.textViewFilmTitle11)
    }*/
}