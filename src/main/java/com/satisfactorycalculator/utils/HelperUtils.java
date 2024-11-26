// This class includes helper utilitites used throughout the program

package com.satisfactorycalculator.utils;

import java.io.IOException;
// Package imports
import java.io.InputStream;
import java.net.URL;

import java.util.List;

import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class HelperUtils {
    // This method returns the open file of a stream
    public static InputStream open(String fileName) throws IOException  {
        // The class loader returns a URL, therefore a URL object is required here
        URL resource = HelperUtils.class.getClassLoader().getResource(fileName);
        
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        // If the file is found, return the stream
        return HelperUtils.class.getClassLoader().getResourceAsStream(fileName);
    }

    public static Map<String,String> getRowAsMap(Sheet sheet, int filterIndex) {
        
        Map<String, String> rowMap = new HashMap<>();
        // Get the headers
        List<String> headers = getHeader(sheet);

        // Get the row
        Row rowList = sheet.getRow(filterIndex);

        // Mapping the rowlist and headers together
        if (rowList != null) {
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = rowList.getCell(i);
                String cellValue = (cell !=null) ? cell.toString() : "";  // if the cell value is null, return an empty string, else the value
                rowMap.put(headers.get(i),cellValue);

            }

        }

        return rowMap;
    }

    public static int doubleIndexFilter(List<Integer> list1, List<Integer> list2) {
        // This helper function returns the same index shared within two integer lists
        
        // Initializing
        int finalInt = 0;
        List<Integer> sharedList = new ArrayList<>();

        // Finding the intersecting values in the list
        Set<Integer> setList1 = new HashSet<>(list1);
        Set<Integer> setList2 = new HashSet<>(list2);
        setList1.retainAll(setList2);
        
        // Share lists
        sharedList.addAll(setList1);

        // Checking if 
        if (sharedList.size() == 1) {
            finalInt = sharedList.get(0);

        } else {
            throw new IllegalArgumentException("More then one index shared when filtering ");
        }
        return finalInt;
    }

    public static List<Integer> filterColsName(List<String> columnValues, String filterName) {
        // This function finds all indexes of an instances of a filterName
        List<Integer> filterLine = new ArrayList<>();
        for (int i = 0; i < columnValues.size(); i++) {
            if (columnValues.get(i).equals(filterName)) {
                filterLine.add(i);
            }
        }
        return filterLine;
    }

    public static Integer filterColsNumber(List<String> columnValues, float filterNumber ) {
        // This method finds an index of the closes filterNumber in the columnValues list (kinda)
        int filterLine = 0;
        
        // Changing the columnValues to a float
        float [] floatColumns = stringToFloats(columnValues);
        // Arrays.sort(floatColumns);  // Do I need to do this? If I do, then I need to keep track of all the values in the data, instead I just assume the columns are sorted in the data set (as it is). Or I could subtract all the values from the wanted value and select the smallest positve or negative one


        int numBelts = 1;
        int maxBelts = 5;
        while (numBelts < maxBelts) {
            float adjustedCap = filterNumber * numBelts;
            for (int i = 0; i < floatColumns.length; i++) {
                if (floatColumns[i] >= adjustedCap) {
                    return i;
                }
            }
        }
        return filterLine;
    }

    public static float[] stringToFloats(List<String> stringList) {
        // This method conversts a string list to a float list
        float[] floatList = new float[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            try {
                floatList[i] = Float.parseFloat(stringList.get(i));
            } catch (NumberFormatException e) {
                floatList[i] = 0;
            }

        }
        return floatList;
    } 

    public static List<String> getHeader(Sheet sheet) {
        // Determine the first row of a sheet, that is the column names
        Row firstRow = sheet.getRow(0);
        List<String> headerNames = new ArrayList<>();
        if (firstRow != null) {
            for (Cell cell: firstRow) {
                if (cell == null || cell.getCellType() == CellType.BLANK) {  // Checking the cell is blank
                    headerNames.add(" ");
                } else {
                    headerNames.add(cell.getStringCellValue());
                } 
            }
        } else {
            throw new IllegalArgumentException("Sheet is empty, no headers found in sheet: " + sheet.getSheetName());
        }

        return headerNames;
    }


    public static List<String> getCellsInCol(Sheet sheet, String columnName) {
        // Finding the index of the Item and item_type columns
        List<String> headerNames = getHeader(sheet); 
        int colInt = headerNames.indexOf(columnName);
        
        // Fail check if column name not in the sheet
        if (colInt == -1) {
            throw new IllegalArgumentException("Column " + columnName + " not found in sheet: " + sheet.getSheetName());
        }

        // Extracting the cell values in the column
        List<String> colValues = new ArrayList<>();
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(colInt);
                if (cell != null) {
                    colValues.add(getCellValueAsString(cell));
                }
            }
        }
        return colValues;
    }

    private static String getCellValueAsString(Cell cell) {
        // This method reads a cell and returns it as a String -> Might not need this in the future        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";

        }

    }

}

