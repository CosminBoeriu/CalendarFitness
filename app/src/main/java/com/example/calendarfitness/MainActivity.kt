package com.example.calendarfitness

import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import java.util.*
import java.util.prefs.Preferences

public lateinit var homeFrag: Fragment
public lateinit var ex1Frag: Fragment
public lateinit var ex2Frag: Fragment
public lateinit var ex3Frag: Fragment
public lateinit var ex4Frag: Fragment
public lateinit var ex5Frag: Fragment
public lateinit var ex6Frag: Fragment

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var day: Any
    var vectorImagini = arrayOf( R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7,)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fragment
        ex1Frag = ex_1_frag( )
        ex2Frag = ex_2_frag( )
        ex3Frag = ex_3_frag( )
        ex4Frag = ex_4_frag( )
        ex5Frag = ex_5_frag( )
        ex6Frag = ex_6_frag( )
        homeFrag = HomeFragment( )
        val DietFrag = DietsFragment( )

        homeApply()

        //Shared Pref Week
        val sharedPref = getSharedPreferences( "weekPref", Context.MODE_PRIVATE )
        val editor = sharedPref.edit( )

        for ( i in 1..7 ){
            val idButon: Int = resources.getIdentifier("ImgButton$i", "id", packageName)
            val button: ImageButton = findViewById<ImageButton>( idButon )
            button.setImageResource( vectorImagini[sharedPref.getInt( "nrOrdine$i", 6 )])
        }

        val ImgButton1 = findViewById<ImageButton>( R.id.ImgButton1 ); ImgButton1.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine1", 0 ) + 1 ) % 7
            ImgButton1.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine1", nrImagine ); apply( )
            }
        }
        val ImgButton2 = findViewById<ImageButton>( R.id.ImgButton2 ); ImgButton2.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine2", 0 ) + 1 ) % 7
            ImgButton2.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine2", nrImagine ); apply( )
            }
        }
        val ImgButton3 = findViewById<ImageButton>( R.id.ImgButton3 ); ImgButton3.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine3", 0 ) + 1 ) % 7
            ImgButton3.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine3", nrImagine ); apply( )
            }
        }
        val ImgButton4 = findViewById<ImageButton>( R.id.ImgButton4 ); ImgButton4.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine4", 0 ) + 1 ) % 7
            ImgButton4.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine4", nrImagine ); apply( )
            }
        }
        val ImgButton5 = findViewById<ImageButton>( R.id.ImgButton5 ); ImgButton5.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine5", 0 ) + 1 ) % 7
            ImgButton5.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine5", nrImagine ); apply( )
            }
        }
        val ImgButton6 = findViewById<ImageButton>( R.id.ImgButton6 ); ImgButton6.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine6", 0 ) + 1 ) % 7
            ImgButton6.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine6", nrImagine ); apply( )
            }
        }
        val ImgButton7 = findViewById<ImageButton>( R.id.ImgButton7 ); ImgButton7.setOnClickListener{
            val nrImagine: Int = ( sharedPref.getInt("nrOrdine7", 0 ) + 1 ) % 7
            ImgButton7.setImageResource( vectorImagini[nrImagine] )
            editor.apply {
                putInt( "nrOrdine7", nrImagine ); apply( )
            }
        }


        //Colorare zi calendar
        day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        var codZi = day.toString( )
        val Myid: Int = resources.getIdentifier("ImgButton$codZi", "id", packageName)
        val ziCalendar: ImageButton = findViewById<ImageButton>(Myid)
        ziCalendar.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#fffd82" ))



        //Navigation Drawer
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLay)
        val navView = findViewById<NavigationView>(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when( it.itemId ){
                R.id.myItem1 -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace( R.id.frameLayFragment, homeFrag )
                        addToBackStack( null )
                        commit( )
                    }
                }
                R.id.myItem2 -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace( R.id.frameLayFragment, DietFrag )
                        addToBackStack( null )
                        commit( )
                    }
                }
            }
            true
        }

    }

    private fun homeApply() {
        supportFragmentManager.beginTransaction().apply {
            replace( R.id.frameLayFragment, homeFrag )
            commit( )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if( toggle.onOptionsItemSelected(item) ){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun replaceFrag( x: Fragment ) {
        supportFragmentManager.beginTransaction( ).apply {
            replace( R.id.frameLayFragment, x )
            addToBackStack( null)
            commit( )
        }
    }

}