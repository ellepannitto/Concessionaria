package callMe;

/**
 *
 * Interfaccia che consente di chiamare una funzione e fornire una descrizione per la funzione chiamata.
 * In questo modo è possibile formare un menu con più voci e eseguire la funzione corrispondente alla scelta dell'utente.
 * 
 * */
public interface CallMe
{
	/**
	 * esegue una funzione generica
	 * */
	public void call ();
	
	/**
	 * restituisce la descrizione della funzione chiamata (ad esempio per essere utilizzata come voce del menu).
	 * */
	public String getDescrizione();
}
