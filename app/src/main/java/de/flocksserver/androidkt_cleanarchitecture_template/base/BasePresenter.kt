package de.flocksserver.androidkt_cleanarchitecture_template.base

/**
 * Created by marcel on 08.08.17.
 */
interface BasePresenter<V : BaseView> {

    var view : V?

    fun resume()

    fun pause()

    fun destroy()

}