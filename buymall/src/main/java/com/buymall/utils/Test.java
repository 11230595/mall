package com.buymall.utils;

import com.framework.core.utils.HTTPUtils;

public class Test extends Thread {
	
	private String name;
	
	public Test(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Test t1 = new Test("线程1");
		Test t2 = new Test("线程2");
		Test t3 = new Test("线程3");
		Test t4 = new Test("线程4");
		Test t5 = new Test("线程5");
		Test t6 = new Test("线程6");
		Test t7 = new Test("线程7");
		Test t8 = new Test("线程8");
		Test t9 = new Test("线程9");
		Test t10 = new Test("线程10");
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}
	
	
	public void run() {
		for(int i=0; i<10000; i++){
			//String url = "http://172.28.2.18:8113/mgs/service.do?service=query_balance&_input_charset=UTF-8&account_type=101&identity_type=MOBILE&partner_id=188888888888&sign_type=RSA&version=1.0&memo=&identity_no=18511833392&sign=wHzuQ42gnu0xjrr43bElxGApPbnMFvULkrf+T1DQWyHBSsNTNrT7yuheOdgt5NQBilYYHxEHfyMddQt4mz9ZoOBQ/Vd+LFU1xP42FpiFUO+bk8j57PBGnGGCMSMojoaw7p2+1NL9GkQ/TujT1t76oqmAorkn+LR66L7/5QQg600=";
			String url = "http://172.28.2.18:8113/mgs/index.html";
			String result = HTTPUtils.sendGet(url);
			
			System.out.println(name + "--->" + result);
		}
    }
}
