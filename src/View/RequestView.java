package View;

import java.util.Vector;

import Model.Request;

public class RequestView {
	public static void showRequests(Vector<Request> requests) {
		for (Request r: requests) {
			System.out.println(r);
		}
	}
}
