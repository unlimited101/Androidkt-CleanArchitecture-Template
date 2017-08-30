package de.flocksserver.androidkt_cleanarchitecture_template.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import de.flocksserver.androidkt_cleanarchitecture_template.App
import de.flocksserver.androidkt_cleanarchitecture_template.di.components.ApplicationComponent

/**
 * Created by marcel on 08.08.17.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    protected fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    protected fun getApplicationComponent(): ApplicationComponent {
        return (application as App).applicationComponent
    }

}
