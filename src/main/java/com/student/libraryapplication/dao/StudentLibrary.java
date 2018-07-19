package com.student.libraryapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentLibrary extends DBManager implements IStudentLibrary {

	public static void main(String[] args) throws SQLException {
		StudentLibrary sl = new StudentLibrary();
		int std = sl.getStdLogin("sravan", "sravan123");
		ArrayList<Books> listBooks = sl.getBooksCheckedOut(std);
		
		for(int i=0;i<listBooks.size();i++){
			System.out.println(listBooks.get(i).getBookId() +":"+listBooks.get(i).getDueDate()+":"+listBooks.get(i).getBookName()+":"+listBooks.get(i).getPrice());
		}
	}

	public int getStdLogin(String stdName, String stdPwd) {

		int stdid_ = 0;
		try {

			getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select stdid from STUDENT where STDNAME='" + stdName + "' and STDPWD='" + stdPwd + "'");

			while (rs.next()) {

				stdid_ = rs.getInt("STDID");
			}
			conn.close();
			stmt.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(stdid_);
		return stdid_;
	}

	public ArrayList<Books> getBooksCheckedOut(int stdId) throws SQLException {
		ArrayList<Books> addressArrayList = new ArrayList<Books>();
		try {

			getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT BC.*,B.AUTHOR,B.BOOKNAME,B.PRICE FROM BOOKSCHECKOUT BC INNER JOIN BOOKS B ON BC.BOOKID=B.BOOKID where STDID=" + stdId);

			while (rs1.next()) {

				Books addOBj = new Books();
				addOBj.setBookId(rs1.getInt(1));
				addOBj.setStdId(rs1.getInt(2));
				addOBj.setCheckOutDate(rs1.getDate(3));
				addOBj.setDueDate(rs1.getDate(4));
				addOBj.setAuthor(rs1.getString("AUTHOR"));
				addOBj.setBookName(rs1.getString("BOOKNAME"));
				addOBj.setPrice(rs1.getInt("PRICE"));
				addressArrayList.add(addOBj);

			}
			conn.close();
			stmt.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return addressArrayList;
	}
}
