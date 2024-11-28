// This class holds all information about the buildings

package com.satisfactorycalculator.models;

import org.apache.poi.ss.usermodel.*;

import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.HelperUtils;

import java.util.List;

import java.util.HashMap;
import java.util.Map;


public class Buildings {
    private Map<String, String> itemRow;
    
    public Buildings(Sheet sheet, String buildingName) {
        List<String> itemColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_ITEM);  // This column is used to filter the Item
        
        // Building tab filtered to find the building
        List<Integer> itemFiltIndex = HelperUtils.filterColsName(itemColumn, buildingName);
        this.itemRow = HelperUtils.getRowAsMap(sheet, itemFiltIndex.get(0));
    }

    public Map<String,String> getFullRow() {
        // This method returns the item rows
        return itemRow;
    }

    //////////// MAP METHODS ////////////
    public Map<String,String> getBuildingMap() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_ITEM,itemRow.get(Constants.DC_ITEM));
        return mapOut;
    }
    public Map<String,String> getPowerMap() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_POWER_USE,itemRow.get(Constants.DC_POWER_USE));
        mapOut.put(Constants.DC_POWER_UNIT,itemRow.get(Constants.DC_POWER_UNIT));
        return mapOut;
    }
    
    //////////// GET METHODS ////////////
    public float getPower() {
        // This method returns the power use of the building
        float powerOut = Float.parseFloat(getPowerMap().get(Constants.DC_POWER_USE));
        return powerOut;
    }

    //////////// PRINT METHODS ////////////
    public void printRow() {
        // This method prints out the filtered row
        for (Map.Entry<String,String> entry: itemRow.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
