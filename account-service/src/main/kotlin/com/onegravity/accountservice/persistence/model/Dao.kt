package com.onegravity.accountservice.persistence.model

import com.onegravity.accountservice.util.NotFoundException

interface Dao<OBJECT, INSERT, UPDATE> {

    fun getAll(): List<OBJECT>

    @Throws(NotFoundException::class)
    fun get(uuid: String): OBJECT

    @Throws(NotFoundException::class)
    fun insert(`object`: INSERT): OBJECT

    @Throws(NotFoundException::class)
    fun update(`object`: UPDATE): OBJECT

    @Throws(NotFoundException::class)
    fun delete(uuid: String): OBJECT

}