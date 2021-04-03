package com.example.homework2

import android.app.ProgressDialog.show
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_dialog.*
import kotlinx.android.synthetic.main.fragment_dialog.view.*
import org.w3c.dom.Text


open class DialogFragment(message: String): DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_dialog, container, false)

        rootView.dialogMessage.text = arguments?.getString("message")

        return rootView
    }
}