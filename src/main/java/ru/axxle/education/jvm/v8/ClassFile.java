package ru.axxle.education.jvm.v8;

import ru.axxle.education.jvm.v8.classfile.*;

import java.util.Arrays;
import java.util.List;

public class ClassFile {
    private Magic magic;
    private Minor_version minor_version;
    private Major_version major_version;
    private Constant_pool_count constant_pool_count;
    private Constant_pool constant_pool;
    private Access_flags access_flags;
    private This_class this_class;
    private Super_class super_class;
    private Interface_count interface_count;
    private Interfaces interfaces;
    private Fields_count fields_count;
    private Object fields;
    private Object methods_count;
    private Object methods;
    private Object attributes_count;
    private Object attributes;
    /*
     u2 fields_count;
     field_info fields[fields_count];
     u2 methods_count;
     method_info methods[methods_count];
     u2 attributes_count;
     attribute_info attributes[attributes_count];
    */

    public List<Item> inTheRightOrder;

    public ClassFile () {
        magic = new Magic();
        minor_version = new Minor_version();
        major_version = new Major_version();
        constant_pool_count = new Constant_pool_count();
        constant_pool = new Constant_pool();
        access_flags = new Access_flags();
        this_class = new This_class();
        super_class = new Super_class();
        interface_count = new Interface_count();
        interfaces = new Interfaces();
        fields_count = new Fields_count();

        inTheRightOrder = Arrays.asList(magic, minor_version, major_version, constant_pool_count, constant_pool,
                access_flags, this_class, super_class, interface_count, interfaces, fields_count);
    }

    @Override
    public String toString(){
        String all = "";
        for(Item item : inTheRightOrder){
            all = all + "\r\n" + item.toStringWithSpecLine();
        }
        return all;
    }

}
