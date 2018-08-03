package ru.axxle.education.jvm.v8.classfile.cpinfo;

public class CONSTANT_MethodType_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] descriptor_index = new byte[2];

    public static final String SPEC_LINE =
            "CONSTANT_MethodType_info {\n" +
                    " u1  tag;\n" +
                    " u2  descriptor_index;\n" +
                    "}";

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        descriptor_index[0] = bytes[cursor + 1];
        descriptor_index[1] = bytes[cursor + 2];
        return cursor + 3;
    }
}
