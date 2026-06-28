package test_Ng_extra_execution;

import org.testng.annotations.Test;

public class Test_ng_types_of_execution {

//	@Test(priority = -1)
//	public void createCity() {
//		System.out.println("noida");
//	}
//	
//	@Test
//	public void modifyCity() {
//		System.out.println("Greater noida");
//		Assert.assertTrue(false);
//	}
//	
//	@Test(priority = 1)
//	public void deleteCity() {
//		System.out.println("Greater noida deleted");
//	}
	
	
	@Test(groups = "smoke")
	public void createCity() {
		System.out.println("noida");
	}
	
	@Test(groups = "reg")
	public void modifyCity() {
		System.out.println("Greater noida");
	}
	
	@Test(groups = "reg")
	public void deleteCity() {
		System.out.println("Greater noida deleted");
	}
}

