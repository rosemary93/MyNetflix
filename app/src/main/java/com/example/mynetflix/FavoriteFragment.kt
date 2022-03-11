package com.example.mynetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    val imageViewsArray = ArrayList<ImageView>()
    val textViewsArray = ArrayList<TextView>()
    var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createImageViewsArray()
        createTextViewsArray()
        if (NetflixEnvironment.userInfo != null) {
            for (film in NetflixEnvironment.filmList) {
                if (film.isFavorite)
                {
                    imageViewsArray[index].setImageResource(film.imageID)
                    textViewsArray[index].text=film.title
                    index++
                }
            }
        }

        binding.buttonFavFrgmntBack.setOnClickListener {
            findNavController().navigate(R.id.action_favoriteFragment_to_homeFragment)
        }
    }

    fun createImageViewsArray() {
        imageViewsArray.add(binding.imageViewFav0)
        imageViewsArray.add(binding.imageViewFav1)
        imageViewsArray.add(binding.imageViewFav2)
        imageViewsArray.add(binding.imageViewFav3)
        imageViewsArray.add(binding.imageViewFav4)
        imageViewsArray.add(binding.imageViewFav5)
        imageViewsArray.add(binding.imageViewFav6)
        imageViewsArray.add(binding.imageViewFav7)
        imageViewsArray.add(binding.imageViewFav8)
        imageViewsArray.add(binding.imageViewFav9)
        imageViewsArray.add(binding.imageViewFav10)
        imageViewsArray.add(binding.imageViewFav11)
    }
    fun createTextViewsArray(){
        textViewsArray.add(binding.textViewTitle0)
        textViewsArray.add(binding.textViewTitle1)
        textViewsArray.add(binding.textViewTitle2)
        textViewsArray.add(binding.textViewTitle3)
        textViewsArray.add(binding.textViewTitle4)
        textViewsArray.add(binding.textViewTitle5)
        textViewsArray.add(binding.textViewTitle6)
        textViewsArray.add(binding.textViewTitle7)
        textViewsArray.add(binding.textViewTitle8)
        textViewsArray.add(binding.textViewTitle9)
        textViewsArray.add(binding.textViewTitle10)
        textViewsArray.add(binding.textViewTitle11)
    }
}