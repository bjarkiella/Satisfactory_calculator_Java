// This class includes all the the finormation about the raw materials
package com.satisfactorycalculator.models;

import org.apache.poi.ss.usermodel.*;

import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.HelperUtils;

import java.util.List;

import java.util.HashMap;
import java.util.Map;


public class RawMat {
    private Map<String, String> itemRow;
    
    public RawMat(Sheet sheet, String rawName) {
        List<String> itemColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_ITEM);  // This column is used to filter the Item
        
        // Building tab filtered to find the building
        List<Integer> itemFiltIndex = HelperUtils.filterCols(itemColumn, rawName);
        this.itemRow = HelperUtils.getRowAsMap(sheet, itemFiltIndex.get(0));
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
    
    public Map<String,String> getQty() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_ITEM_QTY,itemRow.get(Constants.DC_ITEM_QTY));
        return mapOut;
    }

    public Map<String,String> getCraftTime() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_CRAFT_TIME,itemRow.get(Constants.DC_CRAFT_TIME));
        mapOut.put(Constants.DC_CRAFT_TIME_UNIT,itemRow.get(Constants.DC_CRAFT_TIME_UNIT));
        return mapOut;
    }

    public Map<String,String> getFacility() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_CRAFTED_IN,itemRow.get(Constants.DC_CRAFTED_IN));
        return mapOut;
    }

    public Map<String,String> getNode() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_RAW_NODE,itemRow.get(Constants.DC_RAW_NODE));
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