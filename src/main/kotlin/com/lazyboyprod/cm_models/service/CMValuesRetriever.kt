package com.lazyboyprod.cm_models.service

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.util.CellAddress
import org.springframework.stereotype.Component

@Component
class CMValuesRetriever {

    fun retrieve(sheet: Sheet, startingPoint: CellAddress): List<String> {
        println("Try to retrieve values from: ${startingPoint} ")

        var rowNum = startingPoint.row
        val columnNum = startingPoint.column

        var cell = sheet.getRow(rowNum)?.getCell(columnNum)
        val values = mutableListOf<String>()

        while (cell != null && cell.getValueAsString().isNotEmpty()) {
            val v = cell.getValueAsString()
            values.add(v)

            cell = sheet.getRow(++rowNum)?.getCell(columnNum)
        }

        return values
    }

}

public fun Cell.getValueAsString(): String =
    when (this.cellType) {
        CellType.STRING ->  this.stringCellValue
        CellType.NUMERIC -> this.numericCellValue.toLong().toString()
        CellType.BOOLEAN -> this.booleanCellValue.toString()
        else -> ""
    }