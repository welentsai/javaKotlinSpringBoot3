package com.example.demo.service

import com.example.demo.model.Formula
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FormulaServiceTest (@Autowired val formulaService: FormulaService) {
    @Test
    fun `save formula service`() {
        val appleJuiceFormula = Formula(id = "123", name = "Apple Juice", status = "Draft", categories = listOf("Lab1", "Test"), automotiveFlag = "N")
        val orangeJuiceFormula = Formula(id = "456", name = "Orange Juice", status = "Draft", categories = listOf("Lab2", "Test"), automotiveFlag = "N")
        val berryJuiceFormula = Formula(id = "789", name = "Berry Juice", status = "Active", categories = listOf("Lab2", "Demand"), automotiveFlag = "Y")
        val grassJuiceFormula = Formula(id = "101112", name = "Grass Juice", status = "Active", categories = listOf("Lab2", "Demand"), automotiveFlag = "Y")
        val bananaJuiceFormula = Formula(id = "131415", name = "Banana Juice", status = "Active", categories = listOf("Lab3", "Test"), automotiveFlag = "N")
        formulaService.saveFormula(appleJuiceFormula)
        formulaService.saveFormula(orangeJuiceFormula)
        formulaService.saveFormula(berryJuiceFormula)
        formulaService.saveFormula(grassJuiceFormula)
        formulaService.saveFormula(bananaJuiceFormula)
        println(formulaService.getAllFormulas())
        println("=================")
        println(formulaService.findAllBy("Draft"))
        println("================")
        println(formulaService.findFormulaByCriteria("Draft", "N", null))
        println(formulaService.findFormulaByCriteria("Active", "DoNotCare", listOf()))
        println(formulaService.findFormulaByCriteria("Active", "Y", null))
        println(formulaService.findFormulaByCriteria("Active", null, listOf("Lab3")))
        println("================")
        Assertions.assertThat(formulaService.getFormulaById("123")).isEqualTo(appleJuiceFormula)
    }
}