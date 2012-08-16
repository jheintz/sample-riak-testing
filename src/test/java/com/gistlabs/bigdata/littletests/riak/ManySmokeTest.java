package com.gistlabs.bigdata.littletests.riak;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Run the SmokeTest many times
 * 
 * @author jheintz
 *
 */
@RunWith(value = Parameterized.class)
public class ManySmokeTest extends SmokeTest {

	/**
	 */
	public ManySmokeTest(int number) {
	}

	@Parameters
	public static Collection<Object[]> data() {
		int size = 100;
		Collection<Object[]> results = new ArrayList<Object[]>(size);
		for (int i = 1; i < size; i++) { // zero gets messed up, test separately
			results.add(new Object[] { i });
		}
		return results;
	}

}