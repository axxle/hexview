package ru.axxle.education.jvm.v8.classfile.cpinfo;

public class CONSTANT_MethodHandle_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] reference_kind = new byte[1];
    private byte[] reference_index = new byte[4];

    public static final String SPEC_LINE =
            "CONSTANT_MethodHandle_info {\n" +
                    " u1  tag;\n" +
                    " u1  reference_kind;\n" +
                    " u2  reference_index;\n" +
                    "}";

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        reference_kind[0] = bytes[cursor + 1];
        reference_index[0] = bytes[cursor + 2];
        reference_index[0] = bytes[cursor + 3];
        return cursor + 4;
    }
}
