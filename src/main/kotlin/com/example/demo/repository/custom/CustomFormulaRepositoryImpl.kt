package com.example.demo.repository.custom

import com.example.demo.model.Formula
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

open class CustomFormulaRepositoryImpl (private val mongoTemplate: MongoTemplate) : CustomFormulaRepository  {
    override fun findFormulaByCriteria(status: String, automotiveFlag: String?, categories: List<String>?): List<Formula>? {
        println("criteria: status = %s, automotiveFlag = %s".format(status, automotiveFlag))
        val query = Query()
        val criteria = Criteria()

        status?.let {
            criteria.and("status").`is`(status)
        }

        automotiveFlag?.let {
            criteria.and("automotiveFlag").`is`(automotiveFlag)
        }

        if (categories != null) {
            if(categories.size!! > 0 ) {
                criteria.and("categories").`in`(categories)
            }
        }

        query.addCriteria(criteria)
        return mongoTemplate.find(query, Formula::class.java)
    }


}