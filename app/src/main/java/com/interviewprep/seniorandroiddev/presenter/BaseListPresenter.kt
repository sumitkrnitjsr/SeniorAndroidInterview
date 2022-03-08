package com.interviewprep.seniorandroiddev.presenter

import java.lang.ref.WeakReference

abstract class BaseListPresenter<V> {
    private var view : WeakReference<V>? = null

    protected fun getView() = view?.get()

    fun setView(view: V) = { this.view = WeakReference(view) }

}