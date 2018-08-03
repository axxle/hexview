package ru.axxle.education.jvm.v8.classfile.cpinfo;

public class CONSTANT_NameAndType_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] name_index = new byte[2];
    private byte[] descriptor_index = new byte[2];

    public static final String SPEC_LINE = "CONSTANT_NameAndType_info {\n" +
            " u1  tag;\n" +
            " u2  name_index;\n" +
            " u2  descriptor_index;\n" +
            "}";

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        name_index[0] = bytes[cursor + 1];
        name_index[1] = bytes[cursor + 2];
        descriptor_index[0] = bytes[cursor + 3];
        descriptor_index[1] = bytes[cursor + 4];
        return cursor + 5;
    }

}
