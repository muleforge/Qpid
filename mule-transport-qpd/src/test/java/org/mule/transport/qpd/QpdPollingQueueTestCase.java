package org.mule.transport.qpd;

import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;

public class QpdPollingQueueTestCase extends FunctionalTestCase
{
	@Override
	protected String getConfigResources() 
	{
		return "qpd-namespace-configPollingQueue.xml";
	}
	
	public void testTransport()
	{
		MuleClient client = null;
		MuleMessage reply = null;
		try 
		{
		   client = new MuleClient();
		   client.dispatch("vm://inbound", "Testing Qpid Transport!", null);
		   reply = client.request("vm://outbound", 2000);
		} 
		catch (MuleException e) 
		{
		   fail("Exception raised: " + e.getDetailedMessage());
		}
		
		  assertNotNull(reply);
		  assertNotNull(reply.getPayload());
		  assertEquals("Testing Qpid Transport!", reply.getPayload());
	}
}
