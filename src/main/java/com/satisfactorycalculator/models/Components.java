// This class creates an object for components

// Need to refer to some of the helper functions here when reading the lines

package com.satisfactorycalculator.models;

import org.apache.poi.ss.usermodel.*;

import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.HelperUtils;

import java.util.List;

import java.util.HashMap;
import java.util.Map;


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

    //////////// GET METHODS ////////////
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
        String extraCheck = itemRow.get(Constants.DC_EXTRA_ITEM);
        if (!extraCheck.equals("") && !extraCheck.isEmpty() && extraCheck != null) {
            mapOut.put(Constants.DC_EXTRA_ITEM,itemRow.get(Constants.DC_EXTRA_ITEM));
            mapOut.put(Constants.DC_EXTRA_ITEM_QTY,itemRow.get(Constants.DC_EXTRA_ITEM_QTY));
            mapOut.put(Constants.DC_EXTRA_ITEM_UNIT,itemRow.get(Constants.DC_EXTRA_ITEM_UNIT));
        } 
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
        String[] inputMatStrings = {Constants.DC_INPUT_MAT_1,Constants.DC_INPUT_MAT_2,Constants.DC_INPUT_MAT_3,Constants.DC_INPUT_MAT_4};
        String[] inputQtyStrings = {Constants.DC_INPUT_QTY_1,Constants.DC_INPUT_QTY_2,Constants.DC_INPUT_QTY_3,Constants.DC_INPUT_QTY_4};
        String[] inputUnitStrings = {Constants.DC_INPUT_QTY_UNIT_1,Constants.DC_INPUT_QTY_UNIT_2,Constants.DC_INPUT_QTY_UNIT_3,Constants.DC_INPUT_QTY_UNIT_4};
        for (int i=0; i<inputMatStrings.length; i++) {
            if (!inputMatStrings[i].equals("") && inputMatStrings[i] != null && !inputMatStrings[i].isEmpty()) {
                mapOut.put(inputMatStrings[i],itemRow.get(inputQtyStrings[i]));
                mapOut.put(inputQtyStrings[i],itemRow.get(inputQtyStrings[i]));
                mapOut.put(inputUnitStrings[i],itemRow.get(inputUnitStrings[i]));
            } else {
                throw new IllegalArgumentException("No input materials found for item: " + itemRow.get(Constants.DC_ITEM) ); 
            }
        }
        return mapOut;
    }

    public Map<String,String> getFacility() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_CRAFTED_IN,itemRow.get(Constants.DC_CRAFTED_IN));
        return mapOut;
    }

    //////////// PRINT METHODS ////////////

    public void printRow() {
        // This method prints out the filtered row
        for (Map.Entry<String,String> entry: itemRow.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    // private List<String> getItemColumn() {
    //     // This method returns all the items in the item column
    //     return itemColumn;
    // }

    // private List<String> getItemTypeColumn() {
    //     // This method returns all the types in the item column
    //     return itemTypeColumn;
    // }
 


}



