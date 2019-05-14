package 다른패키지;

import 같은패키지.직원;

public class Manager extends 직원 {

		public Manager() {
			System.out.println(name); //public
//			System.out.println(age); //package(default)
//			System.out.println(ssn); //private
			System.out.println(salary); //protected
		}
	}


