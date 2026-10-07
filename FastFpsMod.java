package br.com.fastfps;
import br.com.fastfps.chunk.ChunkUpdateManager;import br.com.fastfps.render.DynamicBudget;
import net.minecraftforge.common.MinecraftForge;import net.minecraftforge.fml.common.Mod;import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;import net.minecraftforge.fml.common.gameevent.TickEvent;
@Mod(modid=FastFpsMod.MOD_ID,name="FastFps",version=FastFpsMod.VERSION,clientSideOnly=true,acceptedMinecraftVersions="[1.9]")
public final class FastFpsMod { public static final String MOD_ID="fastfps",VERSION="1.0.0"; private static ChunkUpdateManager chunks;private static DynamicBudget budget;
 @Mod.EventHandler public void init(FMLInitializationEvent e){budget=new DynamicBudget();chunks=new ChunkUpdateManager();MinecraftForge.EVENT_BUS.register(this);}
 @SubscribeEvent public void tick(TickEvent.ClientTickEvent e){if(e.phase==TickEvent.Phase.END){budget.tick();chunks.tick(budget);}}
 public static ChunkUpdateManager chunks(){return chunks;} public static DynamicBudget budget(){return budget;}
}
