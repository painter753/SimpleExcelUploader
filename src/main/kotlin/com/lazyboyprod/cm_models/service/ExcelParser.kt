package com.lazyboyprod.cm_models.service

import org.apache.poi.ss.util.CellAddress
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class ExcelParser(val workbookProvider: WorkbookProvider, val headerFinder: HeaderFinder, val cmValuesRetriever: CMValuesRetriever) {

    fun parseValues(filename: String?, stream: InputStream): List<String> {
        val workbook = workbookProvider.createVirtualWorkbook(filename!!, stream)

        val sheets = workbook.numberOfSheets
        println("Number of sheets: $sheets")

        val firstSheet = workbook.first()

        val headerAddress = headerFinder.find(firstSheet, "COLORMODEL")
        val startingPoint = if (headerAddress == null) {
            CellAddress("A1")
        } else {
            CellAddress(headerAddress.row + 1, headerAddress.column)
        }

        return cmValuesRetriever.retrieve(firstSheet, startingPoint)
    }
}