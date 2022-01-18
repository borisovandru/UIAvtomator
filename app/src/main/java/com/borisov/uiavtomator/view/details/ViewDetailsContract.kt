package com.borisov.uiavtomator.view.details

import com.borisov.uiavtomator.view.ViewContract

internal interface ViewDetailsContract : ViewContract {
    fun setCount(count: Int)
}