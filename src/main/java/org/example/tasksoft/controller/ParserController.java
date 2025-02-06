package org.example.tasksoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tasksoft.service.XlsxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Tag(name = "Parser", description = "Получение N-го максимального числа из XLSX-файла")
public class ParserController {


    private final XlsxService xlsxService;

    public ParserController(XlsxService xlsxService) {
        this.xlsxService = xlsxService;
    }


    @Operation(summary = "Получить N максимальное число из файла")
    @GetMapping("/max-number")
    public ResponseEntity<Integer> getMaxNumber(@RequestParam() String filePath
            , @RequestParam int number) {
        System.out.println("File path: " + filePath);
        int result = xlsxService.findNthMax(filePath, number);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
