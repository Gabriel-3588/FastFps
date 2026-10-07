package br.com.fastfps;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;import java.util.Map;
@IFMLLoadingPlugin.Name("FastFps") @IFMLLoadingPlugin.MCVersion("1.9") @IFMLLoadingPlugin.TransformerExclusions({"br.com.fastfps."})
public final class FastFpsLoadingPlugin implements IFMLLoadingPlugin { public String[] getASMTransformerClass(){return new String[]{"br.com.fastfps.FastFpsTransformer"};} public String getModContainerClass(){return null;} public String getSetupClass(){return null;} public void injectData(Map<String,Object>d){} public String getAccessTransformerClass(){return null;} }
