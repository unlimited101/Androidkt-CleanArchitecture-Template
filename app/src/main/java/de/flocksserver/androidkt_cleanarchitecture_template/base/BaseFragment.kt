package de.flocksserver.androidkt_cleanarchitecture_template.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.flocksserver.androidkt_cleanarchitecture_template.di.HasComponent

/**
 * Created by marcel on 08.08.17.
 */
abstract class BaseFragment : Fragment() {

    abstract fun getLayoutResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView: View = (inflater?.inflate(getLayoutResource(), container, false) as View)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.initialize()
    }

    protected abstract fun initialize()

    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((activity as HasComponent<*>).getComponent())
    }
}
