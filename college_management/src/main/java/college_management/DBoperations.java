package college_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBoperations 

{
	static Connection con;
	static int teid=0,aid=0;
	

	
	static Connection getcon()  // function for creating connection
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/collegemang","root","reebu312");
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return con;	
	}
	static int addstudent(Student_encap student)    //function for register student
	{
		LocalDateTime now = LocalDateTime.now();    //for local time
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
         String datetime = now.format(format);
		int j=0;
		getcon();
		try 
		{
			PreparedStatement stmt=con.prepareStatement("insert into students(name,phone,email,dob,gender,department,password) values('"+student.getName()+"','"+student.getPhno()+"','"+student.getEmail()+"','"+student.getDob()+"','"+student.getGender()+"','"+student.getDeparment()+"','"+student.getPassword()+"')");
			int i=stmt.executeUpdate(); 
			int sid=0;
			String s="STUDENT";
			if(i==1)
			{
				try 
				{
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select max(slno) as id from students");
					
					while(rs.next())
					{
						 sid=rs.getInt("id");
					}
					System.out.println("max tid= "+sid);
					PreparedStatement stm=con.prepareStatement("insert into login(studentid,phone,role,password,status) values('"+sid+"','"+student.getPhno()+"','"+s+"','"+student.getPassword()+"','"+0+"')");
					j=stm.executeUpdate(); 
					PreparedStatement stt=con.prepareStatement("insert into registration_log(lectureid,adminid,studentid,date,status) values('"+teid+"','"+aid+"','"+sid+"','"+datetime+"','"+0+"')");
					int k=stt.executeUpdate();	
					PreparedStatement stmtt =con.prepareStatement("insert into marklist (studentid,lectureid,malayalam_te,malayalam_ce,english_te,english_ce,maths_te,maths_ce,physics_te,physics_ce,chemistry_te,chemistry_ce,biology_te,biology_ce,it_te,it_ce,socialscience_te,socialscience_ce) values('"+sid+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"')");
				    i=stmtt.executeUpdate();
					} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
				
				
			}
			
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
	return j;
	}
	public List studentinfo(int sid)
	{
		getcon();
	   String id="",name="",NAME="",phn="",email="",dob="",gender="",dep="";
	   int i=0;
	try 
	{
		Statement stm=con.createStatement();
		
		ResultSet rs=stm.executeQuery("select * from students where slno='"+sid+"'");
		while(rs.next())
		{
			i=1;
			id = rs.getString("slno");
			name=rs.getString("name");
			NAME=name.toUpperCase();
			phn=rs.getString("phone");
			email=rs.getString("email");
			dob=rs.getString("dob");
			gender=rs.getString("gender");
			dep=rs.getString("department");
			
		}
		
	} 
	catch (Exception e) 
	{
		System.out.println(e);
	}
		ArrayList ar=new ArrayList();
		ar.add(i);
		ar.add(id);
		ar.add(name);
		ar.add(NAME);
		ar.add(phn);
		ar.add(email);
		ar.add(dob);
		ar.add(gender);
		ar.add(dep);
		ar.add(teid);
		
		return ar;
	}
	
	static int deletestudent(String id)
	{
		getcon();
		int i=0;
		try {
			PreparedStatement stmt=con.prepareStatement("delete from students where slno='"+id+"'");
			i=stmt.executeUpdate();
			if(i==1)
			{
				try 
				{
					PreparedStatement stm=con.prepareStatement("delete from login where studentid='"+id+"'");
					i=stm.executeUpdate();
					i=0;
					PreparedStatement st=con.prepareStatement("delete from registration_log where studentid='"+id+"'");
					i=st.executeUpdate();
				}
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println("delete i= "+i);
		return i;
	}
	
	
	static int addlecture(Lecture_encap lecture)
	{
		getcon();
		int j=0;
		String t="TEACHER";
		try 
		{
			PreparedStatement stmt=con.prepareStatement("insert into lecture(name,phone,email,dob,gender,department,password) values('"+lecture.getName()+"','"+lecture.getPhone()+"','"+lecture.getEmail()+"','"+lecture.getDob()+"','"+lecture.getGender()+"','"+lecture.getDepartment()+"','"+lecture.getPassword()+"')");
			int i=stmt.executeUpdate(); 
			int tid=0;
			System.out.println("i= "+i);
			if(i==1)
			{
				try 
				{
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select max(slno) as id from lecture");
					
					while(rs.next())
					{
						 tid=rs.getInt("id");
					}
					System.out.println("max tid= "+tid);
					PreparedStatement stm=con.prepareStatement("insert into login(teacherid,phone,role,password,status) values('"+tid+"','"+lecture.getPhone()+"','"+t+"','"+lecture.getPassword()+"','"+1+"')");
					j=stm.executeUpdate(); 
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
			
				
			
			System.out.println("j= "+j);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return j;
	}
	
	public List lectureinfo(int idn)
	{
		getcon();
		this.teid=idn;
		String id="",name="",NAME="",phn="",email="",dob="",gender="",dep="";
		int i=0;
		System.out.println("teid="+teid);
		try
		{
            Statement stm=con.createStatement();
			
			ResultSet rs=stm.executeQuery("select * from lecture where slno='"+idn+"'");
			while(rs.next())
			{
				i=1;
				id = rs.getString("slno");
				name=rs.getString("name");
				NAME=name.toUpperCase();
				phn=rs.getString("phone");
				email=rs.getString("email");
				dob=rs.getString("dob");
				gender=rs.getString("gender");
				dep=rs.getString("department");
				
			}
			
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		ArrayList lar=new ArrayList();
		lar.add(i);
		lar.add(id);
		lar.add(name);
		lar.add(NAME);
		lar.add(phn);
		lar.add(email);
		lar.add(dob);
		lar.add(gender);
		lar.add(dep);
		
		return lar;
	}
	
	public List admininfo(int idn)
	{
		getcon();
		teid=0;
		String name="",NAME="",phn="",email="",dob="",gender="",desg="";
		int i=0,id=0;
		try 
		{
            Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from admin where slno='"+idn+"'");
			while(rs.next())
			{
				i=1;
				id = rs.getInt("slno");
				aid=id;
				name=rs.getString("name");
				NAME=name.toUpperCase();
				phn=rs.getString("phone");
				email=rs.getString("email");
				dob=rs.getString("dob");
				gender=rs.getString("gender");
				desg=rs.getString("designation");
				
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		ArrayList aar=new ArrayList();
		
		aar.add(i);
		aar.add(id);
		aar.add(name);
		aar.add(NAME);
		aar.add(phn);
		aar.add(email);
		aar.add(dob);
		aar.add(gender);
		aar.add(desg);
		
		return aar;
	}
	
	public int marklistenter(Marklist_encap mark)
	{
		int i=0;
		
		getcon();
		try
		{
			PreparedStatement stmt =con.prepareStatement("update marklist set lectureid='"+teid+"',malayalam_te='"+mark.getTmark1()+"',malayalam_ce='"+mark.getCemark1()+"',english_te='"+mark.getTmark2()+"',english_ce='"+mark.getCemark2()+"',maths_te='"+mark.getTmark3()+"',maths_ce='"+mark.getCemark3()+"',physics_te='"+mark.getTmark4()+"',physics_ce='"+mark.getCemark4()+"',chemistry_te='"+mark.getTmark5()+"',chemistry_ce='"+mark.getCemark5()+"',biology_te='"+mark.getTmark6()+"',biology_ce='"+mark.getCemark6()+"',it_te='"+mark.getTmark7()+"',it_ce='"+mark.getCemark7()+"',socialscience_te='"+mark.getTmark8()+"',socialscience_ce='"+mark.getCemark8()+"' where studentid='"+mark.getSid()+"'");
		    i=stmt.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return i;
	}
	
	public List marklistprint(int sid)
	{
		getcon();
		String stid="",lid="",mal_te="",mal_ce="",eng_te="",eng_ce="",maths_te="",maths_ce="",phy_te="",phy_ce="",che_te="",che_ce="",bio_te="",bio_ce="",it_te="",it_ce="",ss_te="",ss_ce="";
		int i=0;
		try
		{
            Statement stm=con.createStatement();
			
			ResultSet rs=stm.executeQuery("select * from marklist where studentid='"+sid+"'");
			while(rs.next())
			{
				i=1;
				stid = rs.getString("studentid");
				lid = rs.getString("lectureid");
				mal_te=rs.getString("malayalam_te");
				mal_ce=rs.getString("malayalam_ce");
				eng_te=rs.getString("english_te");
				eng_ce=rs.getString("english_ce");
				maths_te=rs.getString("maths_te");
				maths_ce=rs.getString("maths_ce");
				phy_te=rs.getString("physics_te");
				phy_ce=rs.getString("physics_ce");
				che_te=rs.getString("chemistry_te");
				che_ce=rs.getString("chemistry_ce");
				bio_te=rs.getString("biology_te");
				bio_ce=rs.getString("biology_ce");
				it_te=rs.getString("it_te");
				it_ce=rs.getString("it_ce");
				ss_te=rs.getString("socialscience_te");
				ss_ce=rs.getString("socialscience_ce");				
			}
	} catch (Exception e)
		{
			System.out.println(e);
		}
		ArrayList limr=new ArrayList();
		limr.add(i);
		limr.add(stid);
		limr.add(lid);
		limr.add(mal_te);
		limr.add(mal_ce);
		limr.add(eng_te);
		limr.add(eng_ce);
		limr.add(maths_te);
		limr.add(maths_ce);
		limr.add(phy_te);
		limr.add(phy_ce);
		limr.add(che_te);
		limr.add(che_ce);
		limr.add(bio_te);
		limr.add(bio_ce);
		limr.add(it_te);
		limr.add(it_ce);
		limr.add(ss_te);
		limr.add(ss_ce);
		
		
		return limr;
	}
}

	


