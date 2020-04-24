package v27;

import java.util.Arrays;

public class Spaceship implements Cloneable{

	private String owner;
	
	private Astronaut[] crew;
	
	private int seatsOccupied = 0;
	
	public Spaceship (String owner,int numberOfSeats) {
		this.owner = owner;
		crew = new Astronaut[numberOfSeats];
	}

	public void enter(Astronaut astronaut) {
		if(seatsOccupied < crew.length) {
			if(!alreadySeated(astronaut)) {
				crew[seatsOccupied++] = astronaut;
			} else {
				System.out.println(astronaut + " is already in the ship!");
			}
		} else {
		System.out.println("There are no more free seats!");
	}
}

	public void exit(Astronaut astronaut) {
		if(alreadySeated(astronaut)) {
			Astronaut[] newCrew = new Astronaut[crew.length];
			int newSeatsOccupied = 0;
			for (int i =0 ; i < seatsOccupied; i++) {
				if(!crew[i].equals(astronaut)) {
					newCrew[newSeatsOccupied++] = crew[i];
				}
			}
					crew = newCrew;
			seatsOccupied = newSeatsOccupied;
		}else {
			System.out.println(astronaut+" is not in the ship! ");
		}
	}
	
	public void swap(int i , int j) {
		if(i!= j && i< seatsOccupied && j< seatsOccupied) {
			Astronaut temp = crew[i];
			crew[i] = crew[j];
			crew[j] = temp;
		}else {
			System.out.println("Swapping not possible!");
		}
	}
	
	private boolean alreadySeated(Astronaut astronaut) {
		for (int i = 0 ;i < seatsOccupied; i++) {
			if(crew[i].equals(astronaut)) {
				return true;
			}
		}
		return false;
	}
 
	@Override
	public String toString() {
		String result = owner + "'s spaceship";
		if(seatsOccupied > 0 ) {
			result += ", current crew: ";
			for(int i = 0 ; i< seatsOccupied ; i++) {
				if(i > 0) {
					result += ", ";		
				}
				result += crew[i];
			}
		}
		return result;
	}
	@Override  
	public Object clone() throws CloneNotSupportedException{
		Spaceship clone = new Spaceship(owner,crew.length);
		for(int i = 0; i< seatsOccupied; i++) {
			clone.crew[i] = (Astronaut) crew[i].clone();
		}
		clone.seatsOccupied = seatsOccupied;
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(crew);
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + seatsOccupied;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Spaceship)) {
			return false;
		}
		Spaceship other = (Spaceship) obj;
		if (!Arrays.equals(crew, other.crew)) {
			return false;
		}
		if (owner == null) {
			if (other.owner != null) {
				return false;
			}
		} else if (!owner.equals(other.owner)) {
			return false;
		}
		if (seatsOccupied != other.seatsOccupied) {
			return false;
		}
		return true;
	}

}