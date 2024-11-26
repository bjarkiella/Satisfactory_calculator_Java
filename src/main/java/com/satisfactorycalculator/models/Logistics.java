// This class handles the logistic belts and returns the most suitible given the requested capacity

package com.satisfactorycalculator.models;

import org.apache.poi.ss.usermodel.*;

import com.satisfactorycalculator.utils.Constants;
import com.satisfactorycalculator.utils.HelperUtils;

import java.util.List;

import java.util.HashMap;
import java.util.Map;


public class Logistics {
    private Map<String, String> itemRow;
    
    public Logistics(Sheet sheet, float itemPerMin) {
        List<String> itemColumn = HelperUtils.getCellsInCol(sheet, Constants.DC_ITEM);  // This column is used to filter the Item
        
        // Building tab filtered to find the building
        int itemFiltIndex = HelperUtils.filterColsNumber(itemColumn, itemPerMin);
        this.itemRow = HelperUtils.getRowAsMap(sheet, itemFiltIndex);
    }

    public Map<String,String> getFullRow() {
        // This method returns the item rows
        return itemRow;
    }

    //////////// GET METHODS ////////////
    public Map<String,String> getBelt() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_ITEM,itemRow.get(Constants.DC_ITEM));
        return mapOut;
    }
    public Map<String,String> getCapacity() {
        Map<String,String> mapOut = new HashMap<>();
        mapOut.put(Constants.DC_CAPACITY,itemRow.get(Constants.DC_CAPACITY));
        mapOut.put(Constants.DC_CAPACITY_UNIT,itemRow.get(Constants.DC_CAPACITY_UNIT));
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
