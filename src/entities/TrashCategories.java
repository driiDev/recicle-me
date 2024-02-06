package entities;


public class TrashCategories {

	private String papel;
	private String vidro;
	private String plastico;
	private String metal;
	
	public void PesquisarLixoReciclavel(String categoria) {
		
		if (categoria.equalsIgnoreCase("papel")) {
				System.out.println("Pode ser reciclado.");
				}
				else {
					System.out.println("Não pode ser reciclado ou não foi possível reconhecer esta categoria.");
					}	
		if (categoria.equalsIgnoreCase("vidro")) {
				System.out.println("Pode ser reciclado.");
				}
				else {
					System.out.println("Não pode ser reciclado ou não foi possível reconhecer esta categoria.");
					}
		if (categoria.equalsIgnoreCase("plastico")) {
					System.out.println("Pode ser reciclado.");
					}
				else {
					System.out.println("Não pode ser reciclado ou não foi possível reconhecer esta categoria.");
					}
		if (categoria.equalsIgnoreCase("metal")) {
			System.out.println("Pode ser reciclado.");
			}
			else {
				System.out.println("Não pode ser reciclado ou não foi possível reconhecer esta categoria.");
				}
	}

}

