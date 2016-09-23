package filters;

/**
 * Interfaccia le cui implementazioni sono in grado di filtrare oggetto secondo specifici criteri.
 * */
public interface Filterer<T>
{
	public boolean filter (T t);
}
