package com.satisfactorycalculator.utils;

import org.apache.poi.ss.usermodel.*; 

public class SheetReader {
    private String sheet_name;
    private Sheet sheet;

    // Constructor created
    public SheetReader(Workbook workbook, String sheet_name){
        this.sheet_name = sheet_name;
        this.sheet = workbook.getSheet(sheet_name);

        if (this.sheet == null) {
            throw new IllegalArgumentException("Sheet not found: " + sheet_name);
        }
    }

    public static SheetReader findSheet(SheetReader[] sheets, String sheetName) {
        // Returns a sheet with a given name
        for (SheetReader sheet : sheets) {
            if (sheet.getName().equals(sheetName)) {
                return sheet;
            }
        }
        throw new IllegalArgumentException("Sheet name not found " + sheetName);
    }

    // Return methods defined
    public String getName(){
        return this.sheet_name;
    }

    public Sheet getSheet(){
        return this.sheet;

    }
}
