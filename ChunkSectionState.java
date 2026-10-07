package br.com.fastfps.chunk;
public final class ChunkSectionState {private volatile long generation;private volatile boolean dirty;private volatile ChunkStage stage=ChunkStage.UNLOADED;
 public long invalidate(){dirty=true;return++generation;}public long generation(){return generation;}public boolean dirty(){return dirty;}public void clean(){dirty=false;}public ChunkStage stage(){return stage;}public void stage(ChunkStage s){stage=s;}}
