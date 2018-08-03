package ru.axxle.education.jvm.v8.classfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interfaces extends Item {

    public static final String SPEC_LINE = "u2 interfaces[interfaces_count]; ";

    private Interface_count interface_count = new Interface_count();
    private List<byte[]> interfaces = new ArrayList<>();

    @Override
    public int parseItem(byte[] bytes, int cursor) {
        interface_count.parseItem(bytes, cursor - 2); //...как то так...
        while(interfaces.size() < Item.intFrom2Bytes(interface_count.getItemBytes())){
            interfaces.add(Arrays.copyOfRange(bytes, cursor, cursor + 2));
            cursor = cursor + 2;
        }
        return cursor;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Интерфейсы, шт. " + interfaces.size());
        for(int i = 0; i < interfaces.size(); i++ ){
                stringBuilder.append(i + "\t\t\t см. в constant_pool под индексом " + Item.intFrom2Bytes(interfaces.get(i))).append("\r\n");
        }


        stringBuilder = new StringBuilder().append("\r\n");
        int i = 1;
        for(byte[] iBytes : interfaces){
            stringBuilder.append(". \t\t\t" + i++ + ". " + Item.bytesToHexString(iBytes)).append(" =  СМ. В ПУЛЕ КОНСТАНТ C INDEX = ").append(Item.intFrom2Bytes(iBytes)).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toStringWithSpecLine(){
        return SPEC_LINE + this.toString();
    }
}
