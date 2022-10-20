package com.lazyboyprod.cm_models.representation

import com.lazyboyprod.cm_models.service.ExcelParser
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class FileController(val service: ExcelParser) {

    @PostMapping("/upload")
    @ResponseBody
    fun handle(@RequestParam("file") file: MultipartFile): List<String> {
        println("Receive file ${file.originalFilename}")
        return service.parseValues(file.originalFilename, file.inputStream)
    }

    @GetMapping("/check")
    @ResponseBody
    fun hello() = "I'm OK"

}