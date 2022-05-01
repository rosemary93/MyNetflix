package com.example.mynetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentShowProfileBinding


class ShowUserInfoFragment : Fragment() {
    lateinit var binding: FragmentShowProfileBinding
    val vmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binding.buttonBackToHome.setOnClickListener {
            findNavController().navigate(R.id.action_showProfileFragment_to_homeFragment)
        }
    }

    fun initViews() {
        val user = vmodel.getDataFromSharedPref(requireActivity())
        if (user != null) {
            binding.textViewName.text = "Name : " + user.name
            binding.textViewFamilyname.text = "Family Name : " + user.familyName
            binding.textViewEmail.text = "Email : " + user.emailAddress
            binding.textViewPhoneNumber.text = "Phone Number : " + user.phoneNumber
            binding.textViewUsername.text = "Username : " + user.username
        }
    }


}