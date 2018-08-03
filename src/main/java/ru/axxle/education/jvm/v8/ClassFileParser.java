package ru.axxle.education.jvm.v8;

import ru.axxle.education.jvm.v8.classfile.Item;

public class ClassFileParser {

    public static ClassFile parse (byte[] bytes) {
        ClassFile classFile = new ClassFile();
        int lastCursorValue = 0;
        for(Item item : classFile.inTheRightOrder){
            lastCursorValue = item.parseItem(bytes, lastCursorValue);
        }
        return classFile;
    }

}
