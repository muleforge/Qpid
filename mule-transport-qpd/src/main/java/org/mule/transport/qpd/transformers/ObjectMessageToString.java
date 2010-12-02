package org.mule.transport.qpd.transformers;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageAwareTransformer;

public class ObjectMessageToString extends AbstractMessageAwareTransformer
{
	public ObjectMessageToString()
	{
		registerSourceType(Object.class);
		
		setReturnClass(String.class);
	}

	@Override
	public Object transform(MuleMessage message, String outputEncoding)
			throws TransformerException 
	{
		String result = null;
		ObjectMessage msg = (ObjectMessage) message.getPayload();
		try 
		{
			result = msg.getObject().toString();
		} 
		catch (JMSException e) 
		{
			System.out.println("JMSException in transform: " + e.getMessage());
		}

		return result;
	}

}
