package com.borisov.uiavtomator.presenter.details

import com.borisov.uiavtomator.presenter.PresenterContract

internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}