package com.leonardo.navigationcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_confirmation.*
import java.math.BigDecimal


class ConfirmationFragment : Fragment() {

    private lateinit var beneficiario: String
    private lateinit var monto: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beneficiario = arguments!!.getString("beneficiario").toString()
        monto = arguments!!.getParcelable<Money>("monto")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMensajeConfirmacion.text = "$${monto.amount}.00 MXN fueron enviados a $beneficiario"
    }


}
