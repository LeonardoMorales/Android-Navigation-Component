package com.leonardo.navigationcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_specify_amount.*


class ChooseRecipientFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSiguiente.setOnClickListener { view ->

            if(isInputValue()) {
                val beneficiario: String = textInputBeneficiario.text.toString()
                goToNextFragment(view, beneficiario)
            }


        }

        btnCancelarChooseRecipient.setOnClickListener{ view ->
            activity!!.onBackPressed()
        }
    }

    private fun isInputValue(): Boolean {
        return if(textInputBeneficiario.text.isNullOrBlank()) {
            textInputLayoutBeneficiario.error = "Digite el nombre del beneficiario"
            false
        } else {
            textInputLayoutBeneficiario.isErrorEnabled = false
            true
        }
    }

    private fun goToNextFragment(view: View?, beneficiario: String) {
        val action = ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment(beneficiario)
        view!!.findNavController().navigate(action)
    }

}
