package mono.android.app;

public class ApplicationRegistration {

	public static void registerApplications ()
	{
				// Application and Instrumentation ACWs must be registered first.
		mono.android.Runtime.register ("WoWonder.MainApplication, WoWonder, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", crc643bab5c740f624fb4.MainApplication.class, crc643bab5c740f624fb4.MainApplication.__md_methods);
		
	}
}
