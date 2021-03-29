package com.example.homework2

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.first_fragment.view.*
import kotlinx.android.synthetic.main.second_fragment.*

class FirstFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    val view = inflater.inflate(R.layout.first_fragment, container, false)
        val btn = view.findViewById<TextView>(R.id.tvAlreadyRegistered)
        var message = ""
        val context: FirstFragment = FirstFragment()

        btn?.setOnClickListener{
            val fragment = SecondFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val signUp = view?.findViewById<Button>(R.id.btnSignUp)
        signUp?.setOnClickListener{

            data class Field(
                val name: String,
                val length: Int
            )


            val emailText = Field("email", editTextEmailAddress.text.length)
            val person = Field("имя", editTextPersonName.text.length)
            val person2 = Field("фамилия", editTextPersonName2.text.length)
            val password = Field("пароль", editTextPassword.text.length)
            val password2 = Field("подтверждение пароля", editTextPassword2.text.length)

            if (emailText.length==0)  message = "${emailText.name}, "
            if (person.length==0) message = "$message ${person.name},"
            if (person2.length==0) message = "$message ${person2.name},"
            if (password.length==0) message = "$message ${password.name},"
            if (password2.length==0) message = "$message ${password2.name}"

            message = "Поля $message должны быть заполены корректно!"

            if (editTextPassword.text.trim().toString() != editTextPassword2.text.trim().toString()) message = "$message  Пароли не совпадают!"
            if (password.length < 8 ) message = "$message  Слишком короткий пароль!"

            val intent = Intent()
            intent.putExtra("message", message)

          //  data class User(val email: String, val password: String)
          //  val user = User

            val userEmail = editTextEmailAddress.text.toString()
            val userPassword = editTextPassword.text.toString()
            val userData = "$userEmail $userPassword"

            if ((emailText.length==0) or (person.length==0) or
                    (person2.length==0) or (password.length==0) or (password2.length==0) or
                    (editTextPassword.text.trim().toString() != editTextPassword2.text.trim().toString())
                    or (password.length < 8 ))  {

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
                intent.putExtra("hello", "Успешная регистрация")
                intent.putExtra("user", userData)

                startActivity(intent)
            }


        }

        return view
    }


}