package GarbageCollection;

public class GcTest {
	int value;
	protected void finalize () throws Throwable {
		
		super.finalize();
		System.out.println("Garbage collector calıstı.");
	}

}
