

package com.satisfactorycalculator.utils;


public class MathHelper {

    public static int noMachines(float productionRate, float qty) {
        // This method calculates the number of machines required
        int varOut = (int) Math.ceil(productionRate/qty);
        return Math.max(1, varOut);
    }

    public static float amountPower(float powerUse,int noMachines) {
        // This method calculates the required power
        return powerUse * noMachines;
    }

    public static int powerGen(float powerRequired, float powerGen) {
        // This method calculates the required amount of powergenerator
        int varOut = (int) Math.ceil(powerRequired/powerGen);
        return Math.max(1, varOut);
    }

    public static float itemPerMin(float productionQty, float craftTime) {
        // This method calculates the item per minute of a production output
        return productionQty * 60 / craftTime;
    }

    // Add the overclock math here
}