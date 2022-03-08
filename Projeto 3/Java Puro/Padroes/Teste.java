package project3;

import project3.Facade.Facade;
import project3.Singleton.SingletonEager;
import project3.Singleton.SingletonLazy;
import project3.Singleton.SingletonLazyHolder;
import project3.Strategy.Comportamento;
import project3.Strategy.ComportamentoAgressivo;
import project3.Strategy.ComportamentoDefensivo;
import project3.Strategy.ComportamentoNormal;
import project3.Strategy.Robo;

public class Teste {

	public static void main(String[] args) {

		// Singleton
		
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		
		// Strategy
		
		Comportamento normal = new ComportamentoNormal();
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento agressivo = new ComportamentoAgressivo();
		
		Robo robo = new Robo();
		robo.setComportamento(normal);
		robo.mover();
		robo.mover();
		robo.setComportamento(defensivo);
		robo.mover();
		robo.setComportamento(agressivo);
		robo.mover();
		robo.mover();
		robo.mover();
		
		// Facade
		
		Facade facade = new Facade();
		facade.migrarCliente("Rodrigo", "12345678");
		
	}

}
