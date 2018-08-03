package ru.axxle.education.jvm.v8.classfile;

public abstract class Item {

    protected int itemSize = 1;

    protected byte[] itemBytes = new byte[1];

    public int parseItem(byte[] bytes, int cursor) {
        for ( int i = 0; i < itemSize; i++ ) {
            itemBytes[i] = bytes[cursor + i];
        }
        return cursor + itemSize;
    }

    public abstract String toStringWithSpecLine();

    public static int intFrom2Bytes (byte[] bytes) {
        int n = 0;
        n = (bytes[0] & 0xFF) << 8 | (bytes[1] & 0xFF);
        return n;
    }

    public static String bytesToHexString (byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for(byte b : bytes){
            String s = new String(Integer.toHexString(Byte.toUnsignedInt(b)));
            if(s.length() == 1){
                s = "0" + s;
            }
            builder.append(s).append(" ");
        }
        return builder.toString();
    }
}
