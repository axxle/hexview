package ru.axxle.hexview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.axxle.education.jvm.v8.ClassFile;
import ru.axxle.education.jvm.v8.ClassFileParser;
import ru.axxle.hexview.pojo.ViewItem;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewJ8Controller {

    @RequestMapping(
            value = "/bytecode",
            method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView model = new ModelAndView("bytecode");
        return model;
    }

    @RequestMapping(
            value = "/bytecode",
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

    @RequestMapping(
            value = "/bytecodeview",
            method = RequestMethod.POST)
    ResponseEntity<List<String>> parseClassFile(@RequestParam("file[]") MultipartFile[] files) {
        List<String> list = null;
        if (files != null) {
            if (!files[0].isEmpty()) {
                try {
                    byte[] bytes = files[0].getBytes();
                    list = parseBytes (bytes);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    private static List<String> parseBytes (byte[] bytes) {
        List<String> list = new ArrayList<>();
        ClassFile classFile = ClassFileParser.parse(bytes);
        list.add(classFile.toString());
        return list;
    }
}