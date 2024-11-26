// This class contains all the information about the power generators

package com.satisfactorycalculator.models;

import org.apache.poi.ss.usermodel.*;

import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.HelperUtils;

import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class Power {
    private Map<String, String> itemRow;
    
    public Power(Sheet sheet, String genName, String fuelType) {
        List<String> itemColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_ITEM);  // This column is used to filter the Item
        List<String> itemTypeColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_FUEL_TYPE);  // This column is used to filter item_type
        
        // Use helperutils to find find the item and item type
        List<Integer> itemFiltIndex = HelperUtils.filterColsName(itemColumn, genName);
        List<Integer> itemTypeFiltIndex = HelperUtils.filterColsName(itemTypeColumn, fuelType);
        int filterIndex = HelperUtils.doubleIndexFilter(itemFiltIndex, itemTypeFiltIndex);
        this.itemRow = HelperUtils.getRowAsMap(sheet, filterIndex);
    }

    public Map<String,String> getFullRow() {
        // This method returns the item rows
        return itemRow;
    }

    //////////// GET METHODS ////////////
    public Map<String,String> getGen() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_ITEM,itemRow.get(Constants.DC_ITEM));
        mapOut.put(Constants.DC_FUEL_TYPE,itemRow.get(Constants.DC_FUEL_TYPE));
        return mapOut;
    }

    public Map<String,String> getPowerGen() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_POWER_GEN,itemRow.get(Constants.DC_POWER_GEN));
        mapOut.put(Constants.DC_POWER_GEN_UNIT,itemRow.get(Constants.DC_POWER_GEN_UNIT));
        return mapOut;
    }

    public Map<String,String> getInput() {
        // Only return the ones that are not empty
        Map<String,String> mapOut = new HashMap<>();
        String[] inputMatStrings = {Constants.DC_INPUT_MAT_1,Constants.DC_INPUT_MAT_2};
        String[] inputQtyStrings = {Constants.DC_INPUT_QTY_1,Constants.DC_INPUT_QTY_2};
        String[] inputUnitStrings = {Constants.DC_INPUT_QTY_UNIT_1,Constants.DC_INPUT_QTY_UNIT_2};
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

    //////////// PRINT METHODS ////////////

    public void printRow() {
        // This method prints out the filtered row
        for (Map.Entry<String,String> entry: itemRow.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}

