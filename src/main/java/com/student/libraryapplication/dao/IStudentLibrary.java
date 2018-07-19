package com.student.libraryapplication.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IStudentLibrary {

	public int getStdLogin(String stdName, String stdPwd);
	public ArrayList<Books> getBooksCheckedOut(int stdId) throws SQLException;
}
