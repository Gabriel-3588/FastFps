package br.com.fastfps.api;
public interface IFastFpsPipeline { boolean isProtectedMode();int getPendingChunkTasks();int getPendingUploads();float getFrameTimeMillis();void requestChunk(int x,int z,int priority); }
