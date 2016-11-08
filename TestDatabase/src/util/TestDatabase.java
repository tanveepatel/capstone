package util;
import java.util.List;

import databaseOp.DatabaseOperations;
import model.Resource;

public class TestDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseOperations ope=new DatabaseOperations();
		List<Resource> res=ope.getAllResource();
		System.out.println((res.get(0).getFname()));
		Resource res1=ope.getResourceById("Nim");
		System.out.println(res1.getFname()+ " "+res1.getLname());
	}

}
