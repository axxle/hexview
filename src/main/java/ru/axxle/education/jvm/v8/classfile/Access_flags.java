package ru.axxle.education.jvm.v8.classfile;

import java.util.*;

public class Access_flags extends Item {

    public static final String SPEC_LINE = "u2 access_flags;";

    private int itemSize = super.itemSize = 2;
    private byte[] itemBytes = super.itemBytes = new byte[2];

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(Item.bytesToHexString(itemBytes)).append(" = ").append(Access_flags.fineAccessFlags(itemBytes).toString());
        return stringBuilder.toString().toUpperCase();
    }

    @Override
    public String toStringWithSpecLine(){
        return SPEC_LINE + " HEX==> " + this.toString();
    }

    private static List<String> fineAccessFlags (byte[] bytes) {
        Deque<String> flags = new ArrayDeque<String>();
        if (bytes.length == 2) {
            int accessFlagsNum = Item.intFrom2Bytes(bytes);
            int n = 0x4000;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_ENUM");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x2000;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_ANNOTATION ");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x1000;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_SYNTHETIC ");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x0400;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_ABSTRACT");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x0200;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_INTERFACE");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x0020;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_SUPER");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x0010;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_FINAL");
                accessFlagsNum = accessFlagsNum - n;
            }
            n = 0x0001;
            if(accessFlagsNum % n == 1){
                flags.add("ACC_PUBLIC ");
            }
        }
        return new ArrayList<>(flags);
    }
}
