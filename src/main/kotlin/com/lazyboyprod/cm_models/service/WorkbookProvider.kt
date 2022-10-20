package com.lazyboyprod.cm_models.service

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Component
import java.io.InputStream

@Component
class WorkbookProvider {

    fun createVirtualWorkbook(filename: String, inputStream: InputStream): Workbook {
        inputStream.use {
            var workbook: Workbook? = null
            if (filename!!.lowercase().endsWith("xlsx")) {
                return XSSFWorkbook(it)
            } else if (filename!!.lowercase().endsWith("xls")) {
                return HSSFWorkbook(it)
            } else {
                throw IllegalArgumentException("Bad extension")
            }
        }
    }

}