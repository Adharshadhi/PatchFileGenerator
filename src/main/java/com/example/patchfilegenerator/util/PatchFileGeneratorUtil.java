package com.example.patchfilegenerator.util;

public class PatchFileGeneratorUtil {

    public static String generatePatchFileFormat(String sourceStr){
        StringBuilder result = new StringBuilder();
        String[] splitSourceStr = sourceStr.split("/",2);
        boolean isItom = splitSourceStr[0].equals("ITOM");
        result.append((isItom) ? "ITOM.war/" : "SapphireIMS.war/");
        splitSourceStr = sourceStr.split("\\.");
        boolean isJava = splitSourceStr[1].equals("java");
        if(isJava){
            splitSourceStr = sourceStr.split("/src/");
            String suffix = splitSourceStr[1].replace(".java",".class");
            result.append("WEB-INF/classes/").append(suffix);
        }else{
            splitSourceStr = sourceStr.split("/WebRoot/");
            result.append(splitSourceStr[1]);
        }
        return result.toString();
    }

}
