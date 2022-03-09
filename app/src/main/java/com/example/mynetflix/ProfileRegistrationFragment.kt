package com.example.mynetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentProfileRegistrationBinding


class ProfileRegistrationFragment : Fragment() {
    lateinit var binding: FragmentProfileRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileRegistrationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (NetflixEnvironment.userInfo!=null)
        {
            findNavController().navigate(R.id.action_profileRegistrationFragment_to_showProfileFragment)
        }
        binding.buttonRegister.setOnClickListener {
            if (areValidInputs()) {
                NetflixEnvironment.userInfo = UserInfo(
                    binding.editTextName.text.toString(),
                    binding.editTextFamilyName.text.toString(),
                    binding.editTextEmailAdd.text.toString()
                )
                if (!binding.editTextPhone.text.isNullOrBlank())
                    ((NetflixEnvironment.userInfo) as UserInfo).phoneNumber =
                        binding.editTextPhone.text.toString()
                if (!binding.editTextUsername.text.isNullOrBlank())
                    ((NetflixEnvironment.userInfo) as UserInfo).username =
                        binding.editTextUsername.text.toString()

                findNavController().navigate(R.id.action_profileRegistrationFragment_to_showProfileFragment)

            }
        }
    }

    fun areValidInputs(): Boolean {
        if (binding.editTextName.text.isNullOrBlank()) {
            binding.editTextName.error = "fill here"
            return false
        }
        if (binding.editTextFamilyName.text.isNullOrBlank()) {
            binding.editTextFamilyName.error = "fill here"
            return false
        }
        if (binding.editTextEmailAdd.text.isNullOrBlank()) {
            binding.editTextEmailAdd.error = "fill here"
            return false
        }
        return true
    }


}