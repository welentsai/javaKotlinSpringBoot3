package com.example.demo.service

import com.example.demo.model.Formula
import com.example.demo.repository.FormulaRepository
import com.example.demo.repository.custom.CustomFormulaRepository
import org.springframework.stereotype.Service

@Service
class FormulaService(
    private val formulaRepository: FormulaRepository,
//    private val customFormulaRepository: CustomFormulaRepository
) {

    fun saveFormula(formula: Formula): Formula {
        return formulaRepository.save((formula))
    }

    fun getFormulaById(id: String): Formula? {
        return formulaRepository.findById(id).orElse(null)
    }

    fun getAllFormulas(): List<Formula>? {
        return formulaRepository.findAll()
    }

    fun findFormulaByCriteria(status: String, automotiveFlag: String?, categories: List<String>?): List<Formula>? {
        return formulaRepository.findFormulaByCriteria(status, automotiveFlag, categories)
    }

    fun findAllBy(status: String): List<Formula> {
        return formulaRepository.findAllBy(status)
    }

    fun searchBy(status: String, automotiveFlag: String?, categories: List<String>?): List<Formula>? {
        return formulaRepository.findFormulaByCriteria(status, automotiveFlag, categories)
    }
}