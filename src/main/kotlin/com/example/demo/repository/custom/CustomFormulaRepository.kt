package com.example.demo.repository.custom

import com.example.demo.model.Formula

interface CustomFormulaRepository {
    fun findFormulaByCriteria(status: String, automotiveFlag: String?, categories: List<String>?, name: String?): List<Formula>?
}