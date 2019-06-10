package com.ahead.ASM;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        //被访问者
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/ahead/ASM/Tank.class"));

        //访问者：里面会有关于字节码所有的visitXXX方法
        ClassWriter cw = new ClassWriter(0);

        /**
         * 自定义访问者
         * jdk的动态代理就是这样做的
         * Spring的AOP通过cglib和jdk的动态代理实现的，而这两者底层都是通过asm来操作的
         * 因此Spring的AOP原理就是这样
         */
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {

            //运行时动态的给Tank.class字节码文件中添加了方法
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                //return mv;
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        //动态的给Tank.class字节码中的所有方法执行之前调用TimeProxy.before()
                        visitMethodInsn(INVOKESTATIC, "TimeProxy","before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();

        String path = (String)System.getProperties().get("user.dir");
        File f = new File(path + "/DesignPatterns/com/ahead/ASM/");
        f.mkdirs();

        //指定动态生成的Tank.class文件保存的位置
        FileOutputStream fos = new FileOutputStream(new File(path + "/DesignPatterns/com/ahead/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
