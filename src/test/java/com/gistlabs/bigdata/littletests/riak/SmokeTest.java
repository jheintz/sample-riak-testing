package com.gistlabs.bigdata.littletests.riak;

import org.junit.Before;
import org.junit.Test;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.IRiakObject;
import com.basho.riak.client.RiakFactory;
import com.basho.riak.client.bucket.Bucket;

import static org.junit.Assert.*;

public class SmokeTest {
	IRiakClient riakClient;
	Bucket myBucket;
	
	@Before
	public void setup() throws Exception {
		// create a client (see Configuration below in this README for more details)
		riakClient = RiakFactory.pbcClient();

		// create a new bucket
		myBucket = riakClient.createBucket(Long.toHexString(System.currentTimeMillis())).execute();
	}
	
	@Test
	public void smokeTest() throws Exception {

		// add data to the bucket
		myBucket.store("key1", "value1").execute();

		//fetch it back
		IRiakObject myData = myBucket.fetch("key1").execute();
		assertEquals("value1", myData.getValueAsString());
	}
}
