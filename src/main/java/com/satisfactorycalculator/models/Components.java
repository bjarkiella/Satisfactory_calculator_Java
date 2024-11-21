// This class creates an object for components

// Need to refer to some of the helper functions here when reading the lines

package com.satisfactorycalculator.models;

import org.apache.poi.ss.usermodel.*;

import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.HelperUtils;

import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class Components {
    private String itemName;
    private String itemType;
    private List<String> itemTypeColumn;
    private List<String> itemColumn;
    Map<String, String> itemRow;

    public Components(Sheet sheet, String itemName, String itemType, String sheetName) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_ITEM);  // This column is used to filter the Item
        this.itemTypeColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_ITEM_TYPE);  // This column is used to filter item_type
        
        // Use helperutils to find find the item and item type
        List<Integer> itemFiltIndex = HelperUtils.filterCols(itemColumn, itemName);
        List<Integer> itemTypeFiltIndex = HelperUtils.filterCols(itemTypeColumn, itemType);
        int filterIndex = HelperUtils.doubleIndexFilter(itemFiltIndex, itemTypeFiltIndex);
        Map<String, String> itemRow = new HashMap<>();
        this.itemRow = HelperUtils.getRowAsMap(sheet, filterIndex);

    }

    public Map<String,String> getFullRow() {
        // This method returns the item rows
        return itemRow;

    }

    // Now create some return functions for components, such as item and and type, item qty, extra outputs, all inputs, production facility, production time
    public Map<String,String> getItem() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_ITEM,itemRow.get(Constants.DC_ITEM));
        mapOut.put(Constants.DC_ITEM_TYPE,itemRow.get(Constants.DC_ITEM_TYPE));
        return mapOut;
    }

    public Map<String,String> getQty() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_ITEM_QTY,itemRow.get(Constants.DC_ITEM_QTY));
        mapOut.put(Constants.DC_ITEM_QTY_UNIT,itemRow.get(Constants.DC_ITEM_QTY_UNIT));
        return mapOut;
    }

    public Map<String,String> getExtraOutput() {
        // Change this one to check first if Extra items are present, if not throw error or a message or something
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_EXTRA_ITEM,itemRow.get(Constants.DC_EXTRA_ITEM));
        mapOut.put(Constants.DC_EXTRA_ITEM_QTY,itemRow.get(Constants.DC_EXTRA_ITEM_QTY));
        mapOut.put(Constants.DC_EXTRA_ITEM_UNIT,itemRow.get(Constants.DC_EXTRA_ITEM_UNIT));
        return mapOut;
    }

    public Map<String,String> getCraftTime() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_CRAFT_TIME,itemRow.get(Constants.DC_CRAFT_TIME));
        mapOut.put(Constants.DC_CRAFT_TIME_UNIT,itemRow.get(Constants.DC_CRAFT_TIME_UNIT));
        return mapOut;
    }

    public Map<String,String> getInput() {
        // Only return the ones that are not empty
        Map<String,String> mapOut = new HashMap<>();
        String[] inputStrings = {Constants.DC_INPUT_MAT_1,Constants.DC_INPUT_MAT_2,Constants.DC_INPUT_MAT_3,Constants.DC_INPUT_MAT_4};
        for (String input : inputStrings) {
            if (input.equals("") || input == null || input.isEmpty()) {

            }


        }
        mapOut.put(Constants.DC_CRAFT_TIME,itemRow.get(Constants.DC_CRAFT_TIME));
        mapOut.put(Constants.DC_CRAFT_TIME_UNIT,itemRow.get(Constants.DC_CRAFT_TIME_UNIT));
        return mapOut;
    }


    public void printRow() {
        // This method prints out the filtered row
        for (Map.Entry<String,String> entry: itemRow.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public List<String> getItemColumn() {
        // This method returns all the items in the item column
        return itemColumn;
    }

    public List<String> getItemTypeColumn() {
        // This method returns all the items in the item column
        return itemTypeColumn;
    }

        // Getting all the cells in the DC_ITEM columns
        

        // Finding the 
        

        // Loop throught the itemColumn parts and find the indexes that share itemName
        

        // // Find the itemName and itemType in the column DC.ITEM
        // int itemInt = columnNames.indexOf(Constants.DC_ITEM);
        // int itemTypeInt = columnNames.indexOf(Constants.DC_ITEM_TYPE);
        // if (itemInt == -1) {
        //     throw new IllegalArgumentException("Column "+ Constants.DC_ITEM + " not found in sheet: " + sheet.getSheetName());
        // }
        // if (itemTypeInt == -1) {
        //     throw new IllegalArgumentException("Column "+ Constants.DC_ITEM_TYPE + " not found in sheet: " + sheet.getSheetName());
        // }

        // Search the request item name
        

        // for (int i=0;i<columnNames.size();i++){
        //     if (columnNames.get(i).equals(Constants.DC_ITEM) {
        //         itemInt = i;

        //     }
        // }



    


}



