package com.rongwang.commonutils;

import org.junit.Assert;
import org.junit.Test;

public class MD5UtilsTest {

	@Test
	public void testEncrypt() {
		String data = "abc123";
		Assert.assertEquals("e99a18c428cb38d5f260853678922e03", MD5Utils.encrypt(data));
	}

}
