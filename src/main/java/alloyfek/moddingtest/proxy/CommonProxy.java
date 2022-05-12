package alloyfek.moddingtest.proxy;

import alloyfek.moddingtest.register.BlockRegister;
import alloyfek.moddingtest.register.EventRegister;
import alloyfek.moddingtest.register.ItemRegister;

public class CommonProxy {
	public void register()
	{
		EventRegister.register();
		//EnchantmentRegister.register();
		BlockRegister.register();
		ItemRegister.register();
	}
}