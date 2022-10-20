package com.lazyboyprod.cm_models.service

import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.util.CellAddress
import org.springframework.stereotype.Component

@Component
class HeaderFinder {

    fun find(sheet: Sheet, header: String): CellAddress? {
        println("Number of rows: ${sheet.physicalNumberOfRows}")
        val rowIterator = sheet.rowIterator()

        var headerReference: CellAddress? = null
        while (rowIterator.hasNext()) {
            val row = rowIterator.next()
            val cellsInRowCounter = row.physicalNumberOfCells
            println("Number of cells: ${cellsInRowCounter}")

            val cellIterator = row.cellIterator()
            while (cellIterator.hasNext()) {
                val cell = cellIterator.next()
                if (cell.getValueAsString() == "COLORMODEL") {
                    println("Founded header at adress ${cell.address}")
                    return cell.address
                } else {
                    println("Current value: ${cell.getValueAsString()} at adress: ${cell.address}")
                }
            }
        }
        return null;
    }

}