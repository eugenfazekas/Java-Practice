package common;

import java.util.Comparator;

public class AgeComparator implements Comparator<User>{

	@Override
	public int compare(User user, User anotherUser) {
		
		return Integer.compare(user.getAge(), anotherUser.getAge());
	}

}
