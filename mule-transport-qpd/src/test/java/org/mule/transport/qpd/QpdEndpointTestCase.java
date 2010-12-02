/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.qpd;

import org.mule.api.endpoint.EndpointURI;
import org.mule.endpoint.MuleEndpointURI;
import org.mule.tck.AbstractMuleTestCase;

public class QpdEndpointTestCase extends AbstractMuleTestCase
{

    /* For general guidelines on writing transports see
       http://mule.mulesource.org/display/MULE/Writing+Transports */

	public void testValidEndpointURI() throws Exception
    {
        // TODO test creating and asserting Endpoint values eg

        
        EndpointURI url = new MuleEndpointURI("qpd://direct://amq.direct//queue");
        assertEquals("qpd", url.getScheme());
//        assertEquals("qpd://direct://amq.direct//queue", url.getAddress());
//        assertNull(url.getEndpointName());
        assertEquals(-1, url.getPort());
        assertEquals("direct", url.getHost());
        assertEquals(0, url.getParams().size());
        

       // throw new UnsupportedOperationException("testValidEndpointURI");
    }

}
