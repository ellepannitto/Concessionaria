
public class MultipleFiltererAuto implements Filterer<Auto>
{
	private Filterer<Auto>[] lista_filtri;
	
	public MultipleFiltererAuto (Filterer<Auto>[] lista_condizioni)
	{
		this.lista_filtri = lista_condizioni;
	}
	
	public boolean filter (Auto a)
	{
		boolean ret = true;
		
		for (Filterer<Auto> f : lista_filtri)
		{
			ret = ret && f.filter(a);
		}
		
		return ret;
	}
	
}
