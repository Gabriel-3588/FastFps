package br.com.fastfps;
import net.minecraft.launchwrapper.IClassTransformer;import org.objectweb.asm.*;
public final class FastFpsTransformer implements IClassTransformer { public byte[] transform(String n,String tn,byte[] b){if(b==null||!"net.minecraft.client.renderer.chunk.RenderChunk".equals(tn))return b;try{ClassReader r=new ClassReader(b);ClassWriter w=new ClassWriter(r,ClassWriter.COMPUTE_MAXS);r.accept(new ClassVisitor(Opcodes.ASM5,w){},0);return w.toByteArray();}catch(Throwable t){return b;}}}
