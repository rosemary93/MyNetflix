package com.example.mynetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentShowProfileBinding


class ShowUserInfoFragment : Fragment() {
   lateinit var binding: FragmentShowProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentShowProfileBinding.inflate(inflater,container,false)
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
    fun initViews(){
        binding.textViewName.text="Name : "+NetflixEnvironment.userInfo?.name
        binding.textViewFamilyname.text="Family Name : "+NetflixEnvironment.userInfo?.familyName
        binding.textViewEmail.text="Email : "+NetflixEnvironment.userInfo?.emailAddress
        binding.textViewPhoneNumber.text="Phone Number : "+NetflixEnvironment.userInfo?.phoneNumber
        binding.textViewUsername.text="Username : "+NetflixEnvironment.userInfo?.username
    }


}