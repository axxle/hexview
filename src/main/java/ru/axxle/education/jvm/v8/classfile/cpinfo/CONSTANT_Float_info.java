package ru.axxle.education.jvm.v8.classfile.cpinfo;

public class CONSTANT_Float_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] bytes = new byte[4];

    public static final String SPEC_LINE =
            "CONSTANT_Float_info {\n" +
                    " u1  tag;\n" +
                    " u4  bytes;\n" +
                    "}";

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        this.bytes[0] = bytes[cursor + 1];
        this.bytes[1] = bytes[cursor + 2];
        this.bytes[2] = bytes[cursor + 3];
        this.bytes[3] = bytes[cursor + 4];
        return cursor + 5;
    }
}
