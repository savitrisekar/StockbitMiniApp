package com.example.ministockbitapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.ministockbitapp.R
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            val nameBundle = Bundle()
            nameBundle.putString("nameArgs", edt_username.text.toString())
            it.findNavController().navigate(R.id.stockbitFragment, nameBundle)
        }
    }
}