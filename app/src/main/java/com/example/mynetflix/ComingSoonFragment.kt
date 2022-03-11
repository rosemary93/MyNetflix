package com.example.mynetflix

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentComingSoonBinding


class ComingSoonFragment : Fragment() {
    lateinit var binding: FragmentComingSoonBinding
    val shareButtons = ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComingSoonBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createShareButtonsArray()
        setButtonsEnableOrDisable()
        setListeners()

    }

    fun setButtonsEnableOrDisable() {
        if (NetflixEnvironment.userInfo != null) {
            for (i in 0..2)
                shareButtons[i].isEnabled = true
        } else {
            for (i in 0..2)
                shareButtons[i].isEnabled = false
        }
    }

    private fun setListeners() {
        for (i in 0..2) {
            shareButtons[i].setOnClickListener {
                shareButtons[i].isEnabled = true
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, NetflixEnvironment.comingSoonList[i].title)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

        binding.buttonComingsoonFrgmntBack.setOnClickListener {
            findNavController().navigate(R.id.action_comingSoonFragment_to_homeFragment)
        }
    }

    fun createShareButtonsArray() {
        shareButtons.add(binding.buttonShare0)
        shareButtons.add(binding.buttonShare1)
        shareButtons.add(binding.buttonShare2)
    }


}