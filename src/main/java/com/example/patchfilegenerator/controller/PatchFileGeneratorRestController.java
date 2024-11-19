package com.example.patchfilegenerator.controller;

import com.example.patchfilegenerator.util.PatchFileGeneratorUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
public class PatchFileGeneratorRestController {

    private static final String PATCH_PREFIX = "WebManagement/standalone/deployments/SapphireIMS.ear/";

    @PostMapping("/generatedata")
    public Map<String,String> generatePatchData(@RequestParam String sourceData){
        Map<String, String> resultPatchList = new HashMap<>();
        try{
            String[] filePaths = sourceData.split("\\r?\\n");
            StringBuilder generatedData = new StringBuilder();
            for(String filePath : filePaths){
                generatedData.append(PATCH_PREFIX.concat(PatchFileGeneratorUtil.generatePatchFileFormat(filePath.trim()))).append("\n");
            }
            resultPatchList.put("data", generatedData.toString().trim());
            resultPatchList.put("count", Integer.toString(filePaths.length));
            return resultPatchList;
        }catch (Exception ex){
            System.out.println("Exception caught in generatePatchData method " + ex.getMessage());
        }
        return null;
    }

}
