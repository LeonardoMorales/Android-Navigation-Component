package com.leonardo.navigationcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEnviarDinero.setOnClickListener {view ->
            val action = MainFragmentDirections.actionMainFragmentToChooseRecipientFragment()
            view.findNavController().navigate(action)
        }

        btnVerBalance.setOnClickListener { view ->
            val action = com.leonardo.navigationcomponent.MainFragmentDirections.actionMainFragmentToViewBalanceFragment()
            view.findNavController().navigate(action)
        }

        btnVerTransacciones.setOnClickListener { view ->
            val action = MainFragmentDirections.actionMainFragmentToViewTransactionFragment()
            view.findNavController().navigate(action)
        }

    }


}
