// This is the main file of the program
package com.satisfactorycalculator;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;  // Importing the Workbook object from apache
import org.apache.poi.ss.usermodel.Sheet;

// Importing other classes
import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.ExcelReader;
import com.satisfactorycalculator.utils.SheetReader;


// 

public class Main {

    public static void main(String[] args) {
        // Requested item to be found
        String req_item = "Screw";
        String req_item_type = "Original";
        float req_qty = 120;
        float req_overclock = 100;

        // Power generation defined
        String req_power = "Coal Generator";
        String fuel_type = "Coal";
        float req_power_overclock = 100;
        
        // Declearing some variables
        Workbook workbook = null;
        Sheet[] sheets = new Sheet[Constants.DS_SHEETS.length];

        // Loading the excel file
        try {
            workbook = ExcelReader.loadWorkbook(Constants.DATA_FILE);
            System.out.println(Constants.DATA_FILE+" loaded succesfully");
        }
        catch (IOException e) {
            System.err.println("Error loading " + Constants.DATA_FILE + ", " + e.getMessage());
        }
        
        // Loading the sheets in an array  
        for (int i=0;i<Constants.DS_SHEETS.length;i++){
            sheets[i] = SheetReader.loadSheet(workbook, Constants.DS_SHEETS[i]);
            System.out.println(Constants.DS_SHEETS[i] + " is being loaded");
        }
    
        // Searching for the requested item in the DS_COMP sheet
        // Call the Compoent class here
        // Searching for the requested power gen in DS_POWER sheet
    }

}
