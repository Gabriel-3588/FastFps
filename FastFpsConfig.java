package br.com.fastfps;
public final class FastFpsConfig { private FastFpsConfig(){}
 public static volatile int MAX_QUEUE_SIZE=1024,MAX_BUILDS_PER_TICK=2,MAX_UPLOADS_PER_TICK=1,MAX_UPLOAD_BYTES_PER_TICK=2097152,MAX_PREFETCH=24,PROTECTED_QUEUE_SIZE=192,MAX_WORKERS=2;
 public static volatile float PROTECTED_FRAME_MS=25f;
 public static volatile boolean PREDICTIVE_LOADING=true,PROTECTED_MODE=true,NEVER_WAIT=true,ENTITY_CULLING=true,PARTICLE_BUDGET=true;
 public static void reload(int w,int bytes,int prefetch){MAX_WORKERS=Math.max(1,Math.min(8,w));MAX_UPLOAD_BYTES_PER_TICK=Math.max(262144,bytes);MAX_PREFETCH=Math.max(4,Math.min(128,prefetch));}
}
