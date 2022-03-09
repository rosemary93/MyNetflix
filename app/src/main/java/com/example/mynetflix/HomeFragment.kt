package com.example.mynetflix

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val favoriteButtons = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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


        binding.buttonFavorite0.setOnClickListener {
            NetflixEnvironment.filmList[0].isFavorite = (!NetflixEnvironment.filmList[0].isFavorite)

            binding.buttonFavorite0.setBackgroundColor(Color.RED)
            // findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
        }
    }

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

    fun createButtonArray() {
        favoriteButtons.add(binding.buttonFavorite0)
        favoriteButtons.add(binding.buttonFavorite1)
        favoriteButtons.add(binding.buttonFavorite2)
        favoriteButtons.add(binding.buttonFavorite3)
        favoriteButtons.add(binding.buttonFavorite4)
        favoriteButtons.add(binding.buttonFavorite5)
        favoriteButtons.add(binding.buttonFavorite6)
        favoriteButtons.add(binding.buttonFavorite7)
        favoriteButtons.add(binding.buttonFavorite8)
        favoriteButtons.add(binding.buttonFavorite9)
        favoriteButtons.add(binding.buttonFavorite10)
        favoriteButtons.add(binding.buttonFavorite11)
    }
}