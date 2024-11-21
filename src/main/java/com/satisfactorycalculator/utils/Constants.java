// This file contains all the constants for the program
// Notes: final means this string wont be changed

//package main.java.com.satisfactorycalculator.utils;
package com.satisfactorycalculator.utils;

public class Constants {
    // Name of the excel file
    public static final String DATA_FILE = "item_list.xlsx";

    // Data columns - Components
    public static final String DC_ITEM = "Item";
    public static final String DC_ITEM_TYPE = "item_type";
    public static final String DC_DEFAULT_ITEM_TYPE = "Original";
    public static final String DC_ITEM_QTY = "item_qty";
    public static final String DC_ITEM_QTY_UNIT = "item_qty_unit";

    public static final String DC_EXTRA_ITEM = "extra_item";
    public static final String DC_EXTRA_ITEM_QTY = "extra_item_qty";
    public static final String DC_EXTRA_ITEM_UNIT = "extra_item_qty_unit";

    public static final String DC_CRAFT_TIME = "craft_time";
    public static final String DC_CRAFT_TIME_UNIT = "craft_time_unit";

    public static final String DC_INPUT_MAT = "DC_INPUT_MAT";
    public static final String DC_INPUT_QTY = "DC_INPUT_QTY";
    public static final String DC_INPUT_QTY_UNIT = "DC_INPUT_QTY_UNIT_";
    public static final String DC_INPUT_MAT_1 = "input_mat_1";
    public static final String DC_INPUT_QTY_1 = "input_qty_1";
    public static final String DC_INPUT_QTY_UNIT_1 = "input_qty_unit_1";
    public static final String DC_INPUT_MAT_2 = "input_mat_2";
    public static final String DC_INPUT_QTY_2 = "input_qty_2";
    public static final String DC_INPUT_QTY_UNIT_2 = "input_qty_unit_2";
    public static final String DC_INPUT_MAT_3 = "input_mat_3";
    public static final String DC_INPUT_QTY_3 = "input_qty_3";
    public static final String DC_INPUT_QTY_UNIT_3 = "input_qty_unit_3";
    public static final String DC_INPUT_MAT_4 = "input_mat_4";
    public static final String DC_INPUT_QTY_4 = "input_qty_4";
    public static final String DC_INPUT_QTY_UNIT_4 = "input_qty_unit_4";

    public static final String DC_CRAFTED_IN = "crafted_in";
    public static final String DC_ITEM_PER_MIN = "item_per_min";

    // public static final String[] DC_COMP = {DC_ITEM,DC_ITEM_TYPE}

    // Data columns - Logistics
    public static final String DC_CAPACITY = "capacity";
    public static final String DC_CAPACITY_UNIT = "capacity_unit";

    // Data columns - Power
    public static final String DC_FUEL_TYPE = "fuel_type";
    public static final String DC_POWER_GEN = "power_gen";
    public static final String DC_POWER_GEN_UNIT = "power_gen_unit";
    public static final String DC_POWER_INPUT_MAT = "DC_POWER_INPUT_MAT";
    public static final String DC_POWER_INPUT_QTY = "DC_POWER_INPUT_QTY";
    public static final String DC_POWER_INPUT_QTY_UNIT = "DC_POWER_INPUT_QTY_UNIT";
    public static final String DC_POWER_INPUT_MAT_1 = "input_mat_1";
    public static final String DC_POWER_INPUT_QTY_1 = "input_qty_1";
    public static final String DC_POWER_INPUT_QTY_UNIT_1 = "input_qty_unit_1";
    public static final String DC_POWER_INPUT_MAT_2 = "input_mat_2";
    public static final String DC_POWER_INPUT_QTY_2 = "input_qty_2";
    public static final String DC_POWER_INPUT_QTY_UNIT_2 = "input_qty_unit_2";

    // Data columns - Buildings
    public static final String DC_POWER_USE = "power_consumption";
    public static final String DC_POWER_UNIT = "power_unit";

    // Data columns - Raw Materials
    public static final String DC_RAW_NODE = "node";

    // Naming of Data Sheets
    public static final String DS_RAW = "raw_material";
    public static final String DS_COMP = "components";
    public static final String DS_POWER = "power";
    public static final String DS_BUILD = "buildings";
    public static final String DS_LOG = "logistics";

    // Array of Data Sheets 
    public static final String[] DS_SHEETS = { DS_RAW, DS_COMP, DS_POWER, DS_BUILD, DS_LOG };



}
