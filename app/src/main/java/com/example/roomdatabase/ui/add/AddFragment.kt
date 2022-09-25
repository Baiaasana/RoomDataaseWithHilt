package com.example.roomdatabase.ui.add

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.common.BaseFragment
import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.databinding.FragmentAddBinding
import com.example.roomdatabase.ui.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>(FragmentAddBinding::inflate) {

    private val userViewModel: UserViewModel by viewModels()

    override fun listeners() {

        binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {

        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = binding.etAge.text

        if(inputChecks()){
            Toast.makeText(context, "fill all fields!", Toast.LENGTH_SHORT).show()
        }else{
            //create user obj
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            //add data to database
            userViewModel.addUser(user)
            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToUsersFragment())
        }
    }

    private fun inputChecks(): Boolean = with(binding) {
        return@with binding.etFirstName.text.toString().isEmpty() ||
                binding.etLastName.text.toString().isEmpty() ||
                binding.etAge.text.toString().isEmpty()
    }

    override fun init() {
    }

    override fun observers() {
    }

}