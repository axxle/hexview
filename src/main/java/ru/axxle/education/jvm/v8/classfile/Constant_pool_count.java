package ru.axxle.education.jvm.v8.classfile;

public class Constant_pool_count extends Item {

        public static final String SPEC_LINE = "u2 constant_pool_count;";

        private int itemSize = super.itemSize =  2;
        private byte[] itemBytes = super.itemBytes = new byte[2];

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder()
                    .append(Item.bytesToHexString(itemBytes)).append(" = ").append(Item.intFrom2Bytes(itemBytes));

            return stringBuilder.toString().toUpperCase();
        }

        @Override
        public String toStringWithSpecLine(){
            return SPEC_LINE + " HEX==> " + this.toString();
        }

        public int getIntValue () {
            int n = 0;
            n = (itemBytes[0] & 0xFF) << 8 | (itemBytes[1] & 0xFF);
            return n; //--------------
        }

    }
