package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment =
            FirstFragmentDirections.actionFirstFragmentToSecondFragment()

        binding.button3.setOnClickListener {
            action.message = "Image 1"
            action.image = R.drawable.android_image_1
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.button2.setOnClickListener {
            action.message = "Image 2"
            action.image = R.drawable.android_image_2
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.button1.setOnClickListener {
            action.message = "Image 3"
            action.image = R.drawable.android_image_3
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}