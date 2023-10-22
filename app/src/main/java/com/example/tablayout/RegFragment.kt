package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg, container, false)


        val registerButton = view.findViewById<Button>(R.id.btregister)

        registerButton.setOnClickListener {
            val usernameEditText = view.findViewById<EditText>(R.id.username)
            val emailEditText = view.findViewById<EditText>(R.id.email)
            val phoneEditText = view.findViewById<EditText>(R.id.phone)
            val passwordEditText = view.findViewById<EditText>(R.id.password)

            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                // Tampilkan pesan kesalahan jika ada kolom yang kosong
                Toast.makeText(requireContext(), "Harap isi semua kolom!", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(requireContext(), "Register Successful", Toast.LENGTH_SHORT).show()

                // Pindah ke halaman login
                val fragment = LogFragment() // Gantilah dengan kelas Fragment login Anda
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.addToBackStack(null) // Tambahkan ke tumpukan kembali jika perlu
                transaction.commit()
            }
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
