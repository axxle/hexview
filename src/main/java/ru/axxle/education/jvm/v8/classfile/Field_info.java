package ru.axxle.education.jvm.v8.classfile;

public class Field_info extends Item {

    private byte[] access_flags = new byte[2];
    private byte[] name_index = new byte[2];
    private byte[] descriptor_index = new byte[2];
    private byte[] attributes_count = new byte[2];
    private Attribute_info[] attributes;

    public static final String SPEC_LINE = "field_info {\n" +
            " u2 access_flags;\n" +
            " u2 name_index;\n" +
            " u2 descriptor_index;\n" +
            " u2 attributes_count;\n" +
            " attribute_info attributes[attributes_count];\n" +
            "}";

    @Override
    public String toStringWithSpecLine(){
        return SPEC_LINE + " ==> " + this.toString();
    }

    public class Attribute_info {
        private byte[] attribute_name_index = new byte[2];
        private byte[] attribute_length = new byte[4];
        private byte[] info = new byte[1];
        public static final String SPEC_LINE =
        "attribute_info {\n"+
                " u2 attribute_name_index;\n"+
                " u4 attribute_length;\n"+
                " u1 info[attribute_length];\n"+
                "}";

    }

    public enum Attribute {
    //23 аттрибута:
        //  - 5 обязательных для JVM
                        /*
                    • ConstantValue
                    • Code
                    • StackMapTable
                    • Exceptions
                    • BootstrapMethods
                        */
        //  - 6 обязательных для платформы Java SE
                        /*
                    • InnerClasses
                    • EnclosingMethod
                    • Synthetic
                    • Signature
                    • RuntimeVisibleAnnotations
                    • RuntimeInvisibleAnnotations
                    • RuntimeVisibleParameterAnnotations
                    • RuntimeInvisibleParameterAnnotations
                    • RuntimeVisibleTypeAnnotations
                    • RuntimeInvisibleTypeAnnotations
                    • AnnotationDefault
                    • MethodParameters
                        */
        //  - 12 необязательных
                        /*
                    • SourceFile
                    • SourceDebugExtension
                    • LineNumberTable
                    • LocalVariableTable
                    • LocalVariableTypeTable
                    • Deprecated
                        */
    }
    static class ConstantValue_attribute {
        private byte[] attribute_name_index = new byte[2];
        private byte[] attribute_length = new byte[4];
        private byte[] constantvalue_index = new byte[2];
        public static final String SPEC_LINE = "ConstantValue_attribute {\n" +
                " u2 attribute_name_index;\n" +
                " u4 attribute_length;\n" +
                " u2 constantvalue_index;\n" +
                "}";
    }

    static class Code {
        private byte[] attribute_name_index = new byte[2];
        private byte[] attribute_length = new byte[4];
        private byte[] max_stack = new byte[2];
        private byte[] max_locals = new byte[2];
        private byte[] code_length = new byte[4];
        private byte[] code = new byte[1];
        private byte[] exception_table_length = new byte[2];

        private byte[] $start_pc = new byte[2]; //--------------------------------
        private byte[] end_pc = new byte[2];
        private byte[] handler_pc = new byte[2];
        private byte[] catch_type = new byte[2];
        private byte[] exception_table = new byte[20000];

        private byte[] attributes_count = new byte[2];
        private byte[] attribute_info;

        public static final String SPEC_LINE = "Code_attribute {\n" +
                " u2 attribute_name_index;\n" +
                " u4 attribute_length;\n" +
                " u2 max_stack;\n" +
                " u2 max_locals;\n" +
                " u4 code_length;\n" +
                " u1 code[code_length];\n" +
                " u2 exception_table_length;\n" +
                " { u2 start_pc;\n" +
                " u2 end_pc;\n" +
                " u2 handler_pc;\n" +
                " u2 catch_type;\n" +
                " } exception_table[exception_table_length];\n" +
                " u2 attributes_count;\n" +
                " attribute_info attributes[attributes_count];\n" +
                "}\n";
    }
    static class StackMapTable {
        public static final String SPEC_LINE = "StackMapTable_attribute {\n" +
                " u2 attribute_name_index;\n" +
                " u4 attribute_length;\n" +
                " u2 number_of_entries;\n" +
                " stack_map_frame entries[number_of_entries];\n" +
                "}";
    }
    static class Exceptions {
        public static final String SPEC_LINE = "Exceptions_attribute {\n" +
                " u2 attribute_name_index;\n" +
                " u4 attribute_length;\n" +
                " u2 number_of_exceptions;\n" +
                " u2 exception_index_table[number_of_exceptions];\n" +
                "}";
    }
    static class BootstrapMethods {
        public static final String SPEC_LINE = "BootstrapMethods_attribute {\n" +
                " u2 attribute_name_index;\n" +
                " u4 attribute_length;\n" +
                " u2 num_bootstrap_methods;\n" +
                " { u2 bootstrap_method_ref;\n" +
                " u2 num_bootstrap_arguments;\n" +
                " u2 bootstrap_arguments[num_bootstrap_arguments];\n" +
                " } bootstrap_methods[num_bootstrap_methods];\n" +
                "}\n";
    }
}
