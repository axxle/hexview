package ru.axxle.education.jvm.v8.classfile.cpinfo;

import ru.axxle.education.jvm.v8.classfile.Item;

public class CONSTANT_Class_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] name_index = new byte[2];

    public static final String SPEC_LINE =
            "CONSTANT_Class_info {\n" +
            " u1  tag;\n" +
            " u2  name_index;\n" +
            "}";

    @Override
    public String toStringWithSpecLine() {
        String s = this.getClass().toString().split("\\.")[7];
        int x = Item.intFrom2Bytes(name_index);
        return s + "\t" + x;
    }
    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        name_index[0] = bytes[cursor + 1];
        name_index[1] = bytes[cursor + 2];
        return cursor + 3;
    }

}
