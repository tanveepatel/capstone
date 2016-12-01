 package databaseOp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;


public class readFile {

	private DatabaseOperations dao;
    	
    public void rFile(String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    	{
    	String[] fileData;
    	System.out.println(path);
       // String csvFile ="C:\\Users\\Nimisha\\workspace\\TestDatabase\\WebContent\\WEB-INF\\lib\\TimesheetRawData.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String date, fname,lname,project,hours;
         
        
		
        
        try {
        	
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                 fileData = line.split(cvsSplitBy);
                 
                 date=fileData[0];
                 fname=fileData[1];
                String fname1= fname.replace(fname.charAt(0), ' ');
                 System.out.print(fname1+"\n");
                // fname.replaceFirst("!", "t");
                 lname=fileData[2];
                 String lname1= lname.replace(lname.charAt(lname.length()-1), ' ');
                 project=fileData[3];
                 hours=fileData[5];
                 
                 System.out.println("length is " +fileData.length);
                 
                 if (fileData.length >7){
                	dao.displayProperCSVFileMessage();
                 }
                 

//                 if(fileData[6]!= null){
//                 JOptionPane.showMessageDialog ( 
//         					null, "Please upload proper csv file", "  Upload was unsuccessful", JOptionPane.ERROR_MESSAGE);
//                	 
//                	        System.exit(0);
//                	
//                 }
                 
                
                 else{
                 System.out.println("inside before indertfile data row"+date+" "+fname+" "+lname+" "+project+" "+hours);
                 DatabaseOperations dbop=new DatabaseOperations();
                 
                 dbop.insertFileDataRow(date, fname1, lname1, project, hours);
                 System.out.println(" "+date+" "+fname+" "+lname+" "+project+" "+hours);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
            }
            }
            

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    	}
    

    
       
     
		
    
		
        


}
