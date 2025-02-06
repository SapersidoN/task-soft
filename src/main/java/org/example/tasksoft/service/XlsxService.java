package org.example.tasksoft.service;


import org.apache.poi.ss.usermodel.*;
import org.example.tasksoft.util.MaxFinder;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class XlsxService {

    public int findNthMax(String fileName, int n) {
        List<Integer> numbers = readNumbers(fileName);
        if (numbers.isEmpty()) {
            throw new RuntimeException("в файле нету чисел");
        }
        return MaxFinder.findNth(numbers, n);

    }

    public List<Integer> readNumbers(String fileName) {
        List<Integer> numbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream((fileName));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return numbers;


    }

}
