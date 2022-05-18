package com.example.calendarfitness

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import org.w3c.dom.Text

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val x1: ImageButton = view.findViewById( R.id.btn_exercises1 )
        x1.setOnClickListener{
            ( activity as MainActivity ).replaceFrag( ex1Frag )
        }

        val x2: ImageButton = view.findViewById( R.id.btn_exercises2 )
        x2.setOnClickListener{
            ( activity as MainActivity ).replaceFrag( ex2Frag )
        }
        val x3: ImageButton = view.findViewById( R.id.btn_exercises3 )
        x3.setOnClickListener{
            ( activity as MainActivity ).replaceFrag( ex3Frag )
        }
        val x4: ImageButton = view.findViewById( R.id.btn_exercises4 )
        x4.setOnClickListener{
            ( activity as MainActivity ).replaceFrag( ex4Frag )
        }
        val x5: ImageButton = view.findViewById( R.id.btn_exercises5 )
        x5.setOnClickListener{
            ( activity as MainActivity ).replaceFrag( ex5Frag )
        }
        val x6: ImageButton = view.findViewById( R.id.btn_exercises6 )
        x6.setOnClickListener{
            ( activity as MainActivity ).replaceFrag( ex6Frag )
        }
    }

}