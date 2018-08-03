package ru.axxle.education.jvm.v8.classfile.cpinfo;

public class CONSTANT_Double_info extends Cp_info {
    private byte[] tag = new byte[1];
    private byte[] high_bytes = new byte[4];
    private byte[] low_bytes = new byte[4];

    public static final String SPEC_LINE =
            "CONSTANT_Double_info {\n" +
                    " u1  tag;\n" +
                    " u4  high_bytes;\n" +
                    " u4  low_bytes;\n" +
                    "}";

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        tag[0] = bytes[cursor];
        high_bytes[0] = bytes[cursor + 1];
        high_bytes[0] = bytes[cursor + 2];
        high_bytes[0] = bytes[cursor + 3];
        high_bytes[0] = bytes[cursor + 4];
        low_bytes[0] = bytes[cursor + 5];
        low_bytes[0] = bytes[cursor + 6];
        low_bytes[0] = bytes[cursor + 7];
        low_bytes[0] = bytes[cursor + 8];
        return cursor + 9;
    }
}
