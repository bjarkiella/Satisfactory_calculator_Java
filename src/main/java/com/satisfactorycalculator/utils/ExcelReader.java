package com.satisfactorycalculator.utils;

import org.apache.poi.ss.usermodel.*;  // What is this?
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // What is this?


import java.io.InputStream;  // Package used to open files
import java.io.IOException;


public class ExcelReader {
    
    public static Workbook loadWorkbook(String fileName) throws IOException {
        // This method creates a Workbook object that reads in a excel file
        
        // Open the excel file using the helper utils
        InputStream inputStream = HelperUtils.open(fileName);

        // Workboook object using the apachi package created using the name of the excel file
        Workbook workbook = new XSSFWorkbook(inputStream);
        
        // Reading all the 


        // File stream closed
        inputStream.close();

        return workbook;
    }
    


}


