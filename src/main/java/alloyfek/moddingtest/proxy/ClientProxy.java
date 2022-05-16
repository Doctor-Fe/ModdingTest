package alloyfek.moddingtest.proxy;

import alloyfek.moddingtest.register.ModelRegister;

public class ClientProxy extends CommonProxy
{
	@Override
	public void register() {
		super.register();
		ModelRegister.register();
	}
}