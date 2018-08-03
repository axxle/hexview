package ru.axxle.education.jvm.v8.classfile.cpinfo;

import ru.axxle.education.jvm.v8.classfile.Item;

public class CONSTANT_Utf8_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] length = new byte[2];
    private int intLength;
    private byte[] bytes;

    public static final String SPEC_LINE = "CONSTANT_Utf8_info {\n" +
            "  u1  tag;\n" +
            " u2  length;\n" +
            " u1  bytes[length];\n" +
            "}";

    @Override
    public String toStringWithSpecLine() {
        String s = this.getClass().toString().split("\\.")[7];
        return s + "\t" + new String(bytes);
    }

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        length[0] = bytes[cursor + 1];
        length[1] = bytes[cursor + 2];
        intLength = Item.intFrom2Bytes(length);
        this.bytes = new byte[intLength];
        cursor = cursor + 3;
        for ( int i = 0; i < intLength; i++ ) {
            this.bytes[i] = bytes[cursor + i];
        }
        return cursor + intLength;
    }
}
