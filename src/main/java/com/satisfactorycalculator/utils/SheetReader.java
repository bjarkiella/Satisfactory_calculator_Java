package com.satisfactorycalculator.utils;

import org.apache.poi.ss.usermodel.*; 

public class SheetReader {
    
    public static Sheet loadSheet(Workbook workbook, String sheet_name){

        Sheet sheet = workbook.getSheet(sheet_name);

        return sheet;
    }
}
