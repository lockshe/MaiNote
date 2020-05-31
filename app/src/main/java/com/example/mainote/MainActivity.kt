package com.example.mainote

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Spinner
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.mainote.adapter.NotePageAdapter
import com.example.mainote.fragment.NoteFragment
import com.example.mainote.fragment.TodoFragment
import com.google.android.material.tabs.TabLayout

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = ArrayList<Fragment>().apply {
            add(NoteFragment())
            add(TodoFragment())
        }

        val adapter = NotePageAdapter(supportFragmentManager, list)

        view_pager.adapter = adapter

        note_tab.setupWithViewPager(view_pager)

        note_tab.getTabAt(0)?.apply {
            text = applicationContext.getString(R.string.note)
        }

        note_tab.getTabAt(1)?.apply {
            text = applicationContext.getString(R.string.todo)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}
