package org.mule.transport.qpd;

import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;

public class QpdListenerTopicTestCase extends FunctionalTestCase
{

	@Override
	protected String getConfigResources() 
	{
		return "qpd-namespace-configListenerTopic.xml";
	}
	
	public void testTransport()
	{
		MuleClient client = null;
		MuleMessage reply = null;
		
		try 
		{
			client = new MuleClient();
			client.dispatch("vm://inbound", "Testing Topics...", null);
			reply = client.request("vm://outbound", 2000);
		} 
		catch (MuleException e) 
		{
			fail("Exception raised: " + e.getDetailedMessage());
		}
		
		assertNotNull(reply);
		assertNotNull(reply.getPayload());
		assertEquals("Testing Topics...", reply.getPayload());
	}

}
