package no.hvl.data102.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import no.hvl.data102.*;
import no.hvl.data102.exceptions.EmptyCollectionException;
import no.hvl.data102.tabell.TabellSirkulaerKoe;
import no.hvl.data102.kjedet.*;

class SirkelTest {
	
	Integer tre = 3;
	KoeADT<Integer> t = new TabellSirkulaerKoe<>();
	
	@Test
	void testKjedet() {
		KoeADT kjede = new KjedetKoe<>();
		TestFoerste(kjede);
		kjede = new KjedetKoe<>();
		testToString(kjede);
	}
	@Test
	void testSirkulaerKoe() {
		KoeADT sirkulaer = new TabellSirkulaerKoe<>();
		TestFoerste(sirkulaer);
		sirkulaer = new TabellSirkulaerKoe<>(10);
		testUtvidning(sirkulaer);
	}
	
	void TestFoerste(KoeADT subjekt) {
		Assertions.assertThrows(
				EmptyCollectionException.class,
				() -> {subjekt.foerste();}
				);
		if(!subjekt.erTom())
			fail("Koe er ikkje tom men heiv ikkje unntak");
		
		subjekt.innKoe(3);
		subjekt.innKoe(2);
		subjekt.innKoe(1);
		
		if(subjekt.erTom())
			fail();
		
		assertEquals(subjekt.utKoe(), 3);
		assertEquals(subjekt.foerste(), 2);
		
		
		subjekt.utKoe();
		subjekt.utKoe();
		if(subjekt.erTom())
			return;
		
		fail();
	}
	
	void testUtvidning(KoeADT subjekt) {
		for(int i = 0; i <= 100; i++)
		{
			subjekt.innKoe(i);
		}
	}
	
	void testToString(KoeADT subjekt) {
		subjekt.innKoe(1);
		assertEquals(subjekt.toString(), "1\n");
	}
	
	
	
	

}
