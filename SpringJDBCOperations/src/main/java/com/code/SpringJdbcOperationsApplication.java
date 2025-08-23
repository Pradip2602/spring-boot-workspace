package com.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.code.dao.UserDao;

@SpringBootApplication
public class SpringJdbcOperationsApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcOperationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// -----------INSERT QUERY OPERATION---------------//

//		User user1 = new User("henrick klasen", "henric003@gmail.com", "Male", "7863529865");
//
//		boolean status = userDao.insertUser(user1);
//
//		if (status) {
//			System.out.println("User inserted successfully into DB..........");
//		} else {
//			System.out.println("User not inserted into DB due to some error ..........");

		// ---------------------------------------------------------------------------------------------------------------//

		// -----------UPDATE QUERY OPERATION---------------//

//			User user1 = new User("Johnny Bairastow", "johny001@gmail.com", "Male", "9854231475");
//			boolean status = userDao.updateUser(user1);
//			if (status) {
//				System.out.println("User updated successfully into DB..........");
//			} else {
//				System.out.println("User not updated into DB due to some error ..........");
//			}

		// ---------------------------------------------------------------------------------------------------------------//

		// -----------DELETE QUERY OPERATION---------------//

//		String mobileNo = "9854231475";
//		boolean status = userDao.deleterUser(mobileNo);
//		if (status) {
//			System.out.println("User deleted successfully into DB..........");
//		} else {
//			System.out.println("User not deleted due to some error ..........");
//		}

		// -----------GET USER BY MOBILENO OPERATION---------------//

//		String mobileNo = "9632457896";
//		
//		userDao.getUserByMobileNo(mobileNo);

		// -----------GET ALL USERS BY MOBILENO OPERATION---------------//

		userDao.getAllUser();

	}
}
