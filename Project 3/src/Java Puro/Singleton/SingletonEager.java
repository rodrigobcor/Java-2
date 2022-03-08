package project3.Singleton;

/**
 * Singleton "Apressado"
 * 
 * @author rodrigobcor
 *
 */
public class SingletonEager {

	private static SingletonEager instancia = new SingletonEager();;

	private SingletonEager() {
	}

	public static SingletonEager getInstancia() {
		return instancia;
	}
}
