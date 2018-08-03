package ru.axxle.education.jvm.v8.classfile.cpinfo;

import ru.axxle.education.jvm.v8.classfile.Item;

public class Cp_info extends Item {

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        return super.parseItem(bytes, cursor);
    }

    @Override
    public String toStringWithSpecLine() {
        String s = this.getClass().toString();
        String[] ss = s.split("\\.");
        s = ss[7];
        return s;
    }

    public static Cp_info getEmptyObjectByTag (byte oneByteTag) {
        Cp_info cp_info = null;
        if (oneByteTag == 7) {
            cp_info = new CONSTANT_Class_info();
        }
        else if (oneByteTag == 9) {
            cp_info = new CONSTANT_Fieldref_info();
        }
        else if(oneByteTag == 10) {
            cp_info = new CONSTANT_Methodref_info();
        }
        else if (oneByteTag == 11) {
            cp_info = new CONSTANT_InterfaceMethodref_info();
        }
        else if (oneByteTag == 8) {
            cp_info = new CONSTANT_String_info();
        }
        else if (oneByteTag == 3) {
            cp_info = new CONSTANT_Integer_info();
        }
        else if (oneByteTag == 4) {
            cp_info = new CONSTANT_Float_info();
        }
        else if (oneByteTag == 5) {
            cp_info = new CONSTANT_Long_info();
        }
        else if (oneByteTag == 6) {
            cp_info = new CONSTANT_Double_info();
        }
        else if (oneByteTag == 12) {
            cp_info = new CONSTANT_NameAndType_info();
        }
        else if (oneByteTag == 1) {
            cp_info = new CONSTANT_Utf8_info();
        }
        else if (oneByteTag == 15) {
            cp_info = new CONSTANT_MethodHandle_info();
        }
        else if (oneByteTag == 16) {
            cp_info = new CONSTANT_MethodType_info();
        }
        else if (oneByteTag == 18) {
            cp_info = new CONSTANT_InvokeDynamic_info();
        } else {
            System.out.println("Тег не распознан = " + oneByteTag);
        }
        return cp_info;
    }

}
