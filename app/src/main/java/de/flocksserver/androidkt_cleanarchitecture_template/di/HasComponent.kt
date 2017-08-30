package de.flocksserver.androidkt_cleanarchitecture_template.di

interface HasComponent<C> {
    fun getComponent(): C
}