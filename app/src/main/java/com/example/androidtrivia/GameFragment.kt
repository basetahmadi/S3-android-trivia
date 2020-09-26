package com.example.androidtrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidtrivia.databinding.FragmentGameBinding
import com.example.androidtrivia.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    private var _binding : FragmentGameBinding? = null
    private val binding get() = _binding!!

    private  val viewModel : GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button2.setOnClickListener {
           /* val resultId = binding.radioGroup.checkedRadioButtonId
            val f = view.findViewById<RadioButton>(resultId)
            val x = f.text.toString()

           when(resultId) {
               R.id.radioButton ,R.id.radioButton3,R.id.radioButton4 -> {
                   val action = GameFragmentDirections.actionGameFragmentToGameOverFragment(x)
                   findNavController().navigate(action)
               }
               R.id.radioButton2 -> {
                   val action = GameFragmentDirections.actionGameFragmentToWonFragment(x)
                   findNavController().navigate(action)
               }
           }*/
          viewModel.getNextQuestion()

        }
        viewModel.isfinished.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(R.id.wonFragment)
            }
        })

        viewModel.question.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it.title
            binding.radioButton.text = it.options.get(0)
            binding.radioButton2.text = it.options.get(1)
            binding.radioButton3.text = it.options.get(2)
            binding.radioButton4.text = it.options.get(3)
        })




    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}