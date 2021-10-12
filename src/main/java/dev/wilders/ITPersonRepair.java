package dev.wilders;

public class ITPersonRepair {

    public static String repairName(ITPerson person) {
        String[] tempArrName = person.getName().split("_");
        if (tempArrName.length > 0) {
            String tmpFirstName = tempArrName[0];
            String tmpSecondName = tempArrName[1];
            return (tmpFirstName + " " + tmpSecondName);
        } else {
            return person.getName();
        }
    }
}
