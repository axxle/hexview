package ru.axxle.education.jvm.v8.classfile;

public class Magic extends Item {

    public static final String SPEC_LINE = "u4 magic;";

    private int itemSize = super.itemSize =  4;
    private byte[] itemBytes = super.itemBytes = new byte[4];

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(Item.bytesToHexString(itemBytes));
        return stringBuilder.toString().toUpperCase();
    }

    @Override
    public String toStringWithSpecLine(){
        return SPEC_LINE + " HEX==> " + this.toString();
    }

}
