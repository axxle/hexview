package ru.axxle.education.jvm.v8.classfile;

import ru.axxle.education.jvm.v8.classfile.cpinfo.Cp_info;

import java.util.ArrayList;
import java.util.List;

public class Constant_pool extends Item {

        public static final String SPEC_LINE = "cp_info constant_pool[constant_pool_count-1];";

        private Constant_pool_count constant_pool_count = new Constant_pool_count();
        private List<Cp_info> cpInfoList = new ArrayList<Cp_info>();

        @Override
        public int parseItem(byte[] bytes, int cursor) {
            constant_pool_count.parseItem(bytes, cursor - 2); //...как то так...
            int x = constant_pool_count.getIntValue()-1;
            while(cpInfoList.size() < x){
                Cp_info cp_info = Cp_info.getEmptyObjectByTag(bytes[cursor]);
                cursor = cp_info.parseItem(bytes, cursor);
                cpInfoList.add(cp_info);
            }
            return cursor;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append("\r\n");
            int i = 1;
            for(Cp_info cp_info : cpInfoList){
                stringBuilder.append(". \t\t\t" + i++ + ". " + cp_info.toStringWithSpecLine()).append("\n");
            }
            return stringBuilder.toString();
        }

        @Override
        public String toStringWithSpecLine(){
            return SPEC_LINE + " ==> " + this.toString();
        }

    public void setConstant_pool_count(Constant_pool_count constant_pool_count) {
        this.constant_pool_count = constant_pool_count;
    }
}
