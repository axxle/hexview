package ru.axxle.hexview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

    @RequestMapping(
            value = "/uploadFile",
            method = RequestMethod.POST)
    public ModelAndView uploadTest(@RequestParam("file") MultipartFile file) {
        String fourBytes = "";
        ModelAndView model = new ModelAndView("hexview");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                int[] intMass = new int[bytes.length];

                String[] sMass = new String[bytes.length];

                for (int i = 0; i < bytes.length; i++) {
                    intMass[i] = Byte.toUnsignedInt(bytes[i]);
                    String s = Integer.toHexString(intMass[i]).toUpperCase();
                    if(s.length() == 1) {
                        sMass[i] = "0" + s;
                    } else {
                        sMass[i] = s;
                    }

                    fourBytes = fourBytes + " " + sMass[i];
                }
            } catch (Exception e) {
                model.addObject("sMessage", "FAILED: " + e.getMessage());
                return model;
            }
        }
        model.addObject("sMessage", fourBytes);
        return model;
    }
    @RequestMapping(
            value = "/uploadFiles",
            method = RequestMethod.POST)
    public ModelAndView uploadFilesTest(@RequestParam("file[]") MultipartFile[] file) {
        String fourBytes = "";
        ModelAndView model = new ModelAndView("hexview");
        if(file != null)
            if (!file[0].isEmpty()) {
                try {
                    byte[] bytes = file[0].getBytes();

                    int[] intMass = new int[bytes.length];

                    String[] sMass = new String[bytes.length];

                    for (int i = 0; i < bytes.length; i++) {
                        intMass[i] = Byte.toUnsignedInt(bytes[i]);
                        String s = Integer.toHexString(intMass[i]).toUpperCase();
                        if(s.length() == 1) {
                            sMass[i] = "0" + s;
                        } else {
                            sMass[i] = s;
                        }

                        fourBytes = fourBytes + " " + sMass[i];
                    }
                } catch (Exception e) {
                    model.addObject("sMessage", "FAILED: " + e.getMessage());
                    return model;
                }
            }
        model.addObject("sMessage", fourBytes);
        return model;
    }
}