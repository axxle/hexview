package ru.axxle.education.jvm.v8.classfile;

public class Super_class extends Item {

    public static final String SPEC_LINE = "u2 super_class;";

    private int itemSize = super.itemSize = 2;
    private byte[] itemBytes = super.itemBytes = new byte[2];

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(Item.bytesToHexString(itemBytes)).append(" = см. в пуле констант c index = ").append(Item.intFrom2Bytes(itemBytes));
        return stringBuilder.toString().toUpperCase();
    }

    @Override
    public String toStringWithSpecLine(){
        return SPEC_LINE + " HEX==> " + this.toString();
    }
}
