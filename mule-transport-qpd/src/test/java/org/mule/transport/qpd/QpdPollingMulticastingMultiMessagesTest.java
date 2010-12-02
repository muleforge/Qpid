package org.mule.transport.qpd;

import java.util.ArrayList;

import org.mule.api.MuleException;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;

public class QpdPollingMulticastingMultiMessagesTest extends FunctionalTestCase
{
	ArrayList<String> array = null;
	@Override
	protected String getConfigResources() 
	{
		return "qpd-namespace-configPollingQueue-Multicasting.xml";
	}
	
	public void testMulticasting()
	{
		array = new ArrayList<String>();
		MuleClient client = null;
				
		try 
		{
			client = new MuleClient();
			
			for(int x=0; x<50; x++)
			{
				client.dispatch("vm://inbound", "Testing multicasting..." + x, null);
				
				try 
				{
					array.add((client.request("vm://outbound1", 5000)).getPayloadAsString());
					array.add((client.request("vm://outbound2", 5000)).getPayloadAsString());
				} 
				catch (Exception e) 
				{
					System.out.println("Exception in Testing: " + e.getMessage());
				}
				
			}
		} 
		catch (MuleException e) 
		{
			System.out.println("MuleException raised: " + e.getMessage());
		}
		
//		for(int x=0; x<100; x++)
//		{
//			System.out.println(array.get(x));
//		}
		
		for(int x=0; x<50; x++)
		{
			try 
			{
				if(array.contains("Testing multicasting..." + x))
				{
					array.remove("Testing multicasting..." + x);
				}
				else
				{
					fail();
				}
			
			
				if(array.contains("Testing multicasting..." + x))
				{
					array.remove("Testing multicasting..." + x);
				}
				else
				{
					fail();
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Exception in First Try: " + e.getMessage());
			}
		}
		assertEquals(array.size(), 0);
	}
}
