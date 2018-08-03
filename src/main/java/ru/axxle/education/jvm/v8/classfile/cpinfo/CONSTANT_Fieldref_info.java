package ru.axxle.education.jvm.v8.classfile.cpinfo;

public class CONSTANT_Fieldref_info extends Cp_info{
    private byte[] tag = new byte[1];
    private byte[] class_index = new byte[2];
    private byte[] name_and_type_index = new byte[2];

    public static final String SPEC_LINE = "CONSTANT_Fieldref_info {\n" +
            " u1  tag;\n" +
            " u2  class_index;\n" +
            " u2  name_and_type_index;\n" +
            "}";

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        class_index[0] = bytes[cursor + 1];
        class_index[1] = bytes[cursor + 2];
        name_and_type_index[0] = bytes[cursor + 3];
        name_and_type_index[1] = bytes[cursor + 4];
        return cursor + 5;
    }
}
