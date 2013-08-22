package ru.tsu.csd;

public class Client {
	public static void main(String[] args) {
		Hero h = new Hero();
		h.setState(new AegisOwner());
		h.ifDeath();
		h.setState(new NoAegis());
		h.ifDeath();
	}
}

interface State {
	void ifDeath();
}

class NoAegis implements State {
	public void ifDeath() {
		System.out.println("now u dead");
	}
}

class AegisOwner implements State {
	public void ifDeath() {
		System.out.println("u are going to be respawned after 5 sec");
	}
}

class Hero {
	private State s = new NoAegis();	
	
	public void setState(State state) {
		s = state;
	}
	
	public void ifDeath() {
		s.ifDeath();
	}
}