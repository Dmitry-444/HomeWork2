package com.example.homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.fragment_dialog.*
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.second_fragment, container, false)
        val btn = view.findViewById<TextView>(R.id.tvSignUp)
        var message = ""

        btn?.setOnClickListener{

            val fragment = FirstFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val signUp = view?.findViewById<Button>(R.id.btnSignIn)
        signUp?.setOnClickListener {

            data class Field(
                    val name: String,
                    val length: Int
            )

            val emailText = Field("email", editTextTextEmailAddress.text.length)
            val password = Field("пароль", editTextTextPassword.text.length)

            if (emailText.length==0)  message = "${emailText.name}, "
            if (password.length==0) message = "$message ${password.name}"

            message = "Поля $message должны быть заполены корректно!"

            if (password.length < 8 ) message = "$message  Слишком короткий пароль!"

            val intent = Intent()
            intent.putExtra("message", message)

            val userEmail = editTextTextEmailAddress.text.toString()
            val userPassword = editTextTextPassword.text.toString()
            val userData = "$userEmail $userPassword"

            if ((emailText.length==0) or (password.length==0) or (password.length < 8 )) {

                val dialog = DialogFragment(message)
                val bundle = Bundle()
                bundle.putString("message", message)
                dialog.arguments = bundle
                dialog.show(activity?.supportFragmentManager as FragmentManager, "message")
                message = ""

            }

            else {
                message = ""
                val intent = Intent(getContext(), MainMenuActivity::class.java)
                intent.putExtra("hello", "Привет, рады снова тебя видеть!")
                intent.putExtra("user", userData)

                startActivity(intent)
            }

         //   class User(email: String, password: String) {
         //       val email = editTextTextEmailAddress.text
         //       val password = editTextTextPassword.text
         //   }
        }

        return view
    }
}
