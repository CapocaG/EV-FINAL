package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryP;
	private final VentaRepository repositoryV;
	
	private final VentaDetalleRepository repositoryDV;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryP,
		 VentaRepository repositoryV,
		 VentaDetalleRepository repositoryDV) {
		this.repositoryP = repositoryP;
		this.repositoryV = repositoryV;
		this.repositoryDV = repositoryDV;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Producto pGalleta = new Producto("Ritz", 3);
		Producto pBebida = new Producto("Coca Cola", 4);
		Producto pFruta = new Producto("Fresa", 4);
		this.repositoryP.save(new Producto("Piqueos",3));
		this.repositoryP.save(new Producto("7up",3));
		this.repositoryP.save(new Producto("Picaras", 1));
		this.repositoryP.save(pGalleta);
		this.repositoryP.save(pBebida);
		this.repositoryP.save(pFruta);
		this.repositoryP.save(new Producto("Chirimoya",8));



		VentaDetalle intFruta = new VentaDetalle(10, "arturo", pFruta);
		this.repositoryDV.save(intFruta);
		VentaDetalle intBebida = new VentaDetalle(20,"katherine",pGalleta);
		this.repositoryDV.save(intBebida);
		VentaDetalle intGalleta = new VentaDetalle(21,"cristian",pBebida);
		this.repositoryDV.save(intGalleta);


	}

	
}