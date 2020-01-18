package com.leonardo.navigationcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {

    lateinit var beneficiario: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beneficiario = arguments!!.getString("beneficiario").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvBeneficiario.text = "Enviando dinero a $beneficiario"

        btnEnviar.setOnClickListener { view ->

            if(isInputValid()) {
                val monto = Money(textInputCantidad.text.toString().toBigDecimal())
                passToNextFragment(view, monto)
            }


        }

        btnCancelarSpecifyAmount.setOnClickListener { view ->
            activity!!.onBackPressed()
        }

    }

    private fun isInputValid(): Boolean {
        return if(textInputCantidad.text.isNullOrBlank()){
            textInputLayoutCantidad.error = "Digite la cantidad que desea enviar"
            false
        } else {
            textInputLayoutCantidad.isErrorEnabled = false
            true
        }
    }

    private fun passToNextFragment(view: View, monto: Money) {
        val action = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(beneficiario, monto)
        view.findNavController().navigate(action)
    }

}
